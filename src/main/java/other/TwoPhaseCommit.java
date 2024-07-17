package other;

/**
 * Demonstrates the Two Phase Commit (2PC) protocol for transaction processing systems.
 *
 * <p> The 2PC protocol is a distributed algorithm that ensures all participating resources
 * commit to a transaction or abort (rollback) it, providing a guarantee of atomicity and
 * consistency. In this program, instances of the other.ResourceManager class represent participating
 * resources in the transaction.
 *
 * <p> The algorithm is performed as follows:
 * <ol>
 *  <li>The other.TransactionManager is initialized with the resources (ResourceManagers).</li>
 *  <li>The transaction is started using {@code begin()} method of the other.TransactionManager.</li>
 *  <li>Resources are prepared for the transaction using the {@code prepare()} method.</li>
 *  <li>The transaction is committed using the {@code commit()} method. If all resources
 *  verify and accept the transaction, the transaction is committed; otherwise, it fails and
 *  {@link TransactionException} is thrown.</li>
 *  <li>Upon a failed transaction, resources are rolled back using the {@code rollback()}
 *  method to undo the changes made during the {@code prepare()} phase.</li>
 * </ol>
 *
 * @see ResourceManager
 * @see TransactionManager
 */
public class TwoPhaseCommit {

  public static void main(String[] args) {
    ResourceManager resource1 = new ResourceManager("Resource 1");
    ResourceManager resource2 = new ResourceManager("Resource 2");
    TransactionManager tm = new TransactionManager(resource1, resource2);

    try {
      tm.begin();
      tm.prepare();
      tm.commit();
      System.out.println("Transaction committed successfully!");
    } catch (TransactionException e) {
      tm.rollback();
      System.out.println("Transaction failed: " + e.getMessage());
    }
  }
}

/**
 * The other.TransactionManager class manages the transactions among the participating resources.
 *
 * <p> This class encapsulates the logic for the two phases in the 2PC protocol:
 * <ul>
 *  <li> Prepare phase: This phase starts with the {@code begin()} method and then prepares
 *  the resources for the transaction using the {@code prepare()} method.
 *  <li> Commit/Rollback phase: This phase commits the transaction if all resources are ready.
 *  If any resource fails, the transaction is rolled back. The outcome is decided in the
 *  {@code commit()} method, and in case of a failure, the {@code rollback()} method is invoked.
 * </ul>
 *
 * @see ResourceManager
 */
class TransactionManager {
  private final ResourceManager resource1;
  private final ResourceManager resource2;
  private boolean preparePhaseSuccess = false;

  public TransactionManager(ResourceManager resource1, ResourceManager resource2) {
    this.resource1 = resource1;
    this.resource2 = resource2;
  }

  public void begin() {
    System.out.println("Transaction started...");
  }

  public void prepare() throws TransactionException {
    try {
      resource1.prepare("Data for Resource 1");
      resource2.prepare("Data for Resource 2");
      preparePhaseSuccess = true;
    } catch (TransactionException e) {
      throw new TransactionException("Prepare phase failed: " + e.getMessage());
    }
  }

  public void commit() throws TransactionException {
    if (preparePhaseSuccess) {
      resource1.commit();
      resource2.commit();
      System.out.println("Transaction committed!");
    } else {
      throw new TransactionException("Transaction not prepared for commit!");
    }
  }

  public void rollback() {
    if (preparePhaseSuccess) {
      resource1.rollback();
      resource2.rollback();
      System.out.println("Transaction rolled back!");
    } else {
      System.out.println("No resources to rollback as prepare phase never succeeded.");
    }
  }
}

/**
 * The other.ResourceManager class represents a resource participating in a transaction managed by the
 * {@link TransactionManager}.
 *
 * <p> In the context of the Two Phase Commit protocol, each other.ResourceManager must be able to:
 * <ul>
 *  <li> Prepare for a transaction: This involves any necessary steps to get the resource
 *  ready for making changes as part of a transaction. In this case, the {@code prepare} method is used;
 *  <li> Commit changes in a transaction: Once all resources have successfully prepared, they are asked to
 *  commit the transaction. This is simulated by the {@code commit} method;
 *  <li> Rollback (undo) changes if a transaction fails: If any resource fails to prepare or a problem occurs
 *  during commit, all changes made during the preparation should be undone for consistency. This is performed by the
 *  {@code rollback} method.
 * </ul>
 *
 * <p> The class can also simulate a failure during the preparation phase with a pre-defined probability.
 */
class ResourceManager {
  private final String name;

  public ResourceManager(String name) {
    this.name = name;
  }

  public void prepare(String data) throws TransactionException {

    // e.g., locking or pre-updating data, Locking means mark aLOCK on a transaction
    System.out.println(name + " preparing data: " + data);

    // TODO FIX: Remove if you require always successful commit
    // Simulate potential failure during prepare

    if (Math.random() < 0.2) { // 20% of failure
      throw new TransactionException(name + " preparation failed!");
    }
  }

  public void commit() throws TransactionException {
    // Simulate resource commit (e.g., persisting data changes)
    System.out.println(name + " committing data...");
  }

  public void rollback() {
    // Simulate resource rollback (e.g., undoing - unlocvking data changes)
    System.out.println(name + " rolling back data...");
  }
}

class TransactionException extends Exception {
  public TransactionException(String message) {
    super(message);
  }
}

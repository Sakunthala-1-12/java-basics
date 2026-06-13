import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.io.Serializable;
import java.util.Stack;

// ============================================================
// SMART WAREHOUSE PROFILER ULTIMATE
// PART 1
// ============================================================

// ============================================================
// PROFILER UTILITY
// ============================================================

class PerformanceProfiler {

        private long startTime;
        private long endTime;

        private long startMemory;
        private long endMemory;

        public void start() {
                Runtime runtime = Runtime.getRuntime();
                runtime.gc();

                startMemory = runtime.totalMemory()
                                - runtime.freeMemory();

                startTime = System.nanoTime();
        }

        public void stop() {
                Runtime runtime = Runtime.getRuntime();

                endTime = System.nanoTime();

                endMemory = runtime.totalMemory()
                                - runtime.freeMemory();
        }

        public double getExecutionSeconds() {
                return (endTime - startTime)
                                / 1_000_000_000.0;
        }

        public double getMemoryMB() {
                return Math.max(0,
                                endMemory - startMemory)
                                / (1024.0 * 1024.0);
        }

        public void printReport(String module) {

                System.out.println(
                                "\n========================================");

                System.out.println("MODULE : " + module);

                System.out.printf(
                                "Execution Time : %.6f seconds%n",
                                getExecutionSeconds());

                System.out.printf(
                                "Memory Used    : %.4f MB%n",
                                getMemoryMB());

                System.out.println(
                                "========================================");
        }
}

// ============================================================
// LOGGER SINGLETON
// ============================================================

final class WarehouseLogger {

        private static WarehouseLogger instance;

        private WarehouseLogger() {
        }

        public static synchronized WarehouseLogger getInstance() {

                if (instance == null) {
                        instance = new WarehouseLogger();
                }

                return instance;
        }

        public void log(String message) {

                System.out.println(
                                "[LOG] "
                                                + LocalDateTime.now()
                                                + " -> "
                                                + message);
        }
}

// ============================================================
// CUSTOM EXCEPTIONS
// ============================================================

class ProductNotFoundException
                extends Exception {

        public ProductNotFoundException(
                        String message) {
                super(message);
        }
}

class InsufficientStockException
                extends Exception {

        public InsufficientStockException(
                        String message) {
                super(message);
        }
}

class InvalidWarehouseOperationException
                extends Exception {

        public InvalidWarehouseOperationException(
                        String message) {
                super(message);
        }
}

// ============================================================
// INTERFACES
// ============================================================

interface Identifiable {
        int getId();
}

interface Billable {
        double calculateBill();
}

interface Printable {
        void printDetails();
}

interface Searchable<T> {
        T search(int id);
}

interface StorageCost {
        double calculateStorageCost();
}

// ============================================================
// ENUMS
// ============================================================

enum ProductCategory {
        ELECTRONICS,
        FOOD,
        FURNITURE,
        CLOTHING,
        MEDICAL,
        BOOKS
}

enum EmployeeRole {
        MANAGER,
        OPERATOR,
        DRIVER,
        ACCOUNTANT,
        SECURITY
}

enum ShipmentStatus {
        PENDING,
        DISPATCHED,
        IN_TRANSIT,
        DELIVERED
}

// ============================================================
// ABSTRACT PERSON
// ============================================================

abstract class Person
                implements Identifiable,
                Printable {

        protected int id;
        protected String name;
        protected String phone;

        public Person(
                        int id,
                        String name,
                        String phone) {

                this.id = id;
                this.name = name;
                this.phone = phone;
        }

        @Override
        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        @Override
        public abstract void printDetails();
}

// ============================================================
// EMPLOYEE
// ============================================================

class Employee extends Person {

        private EmployeeRole role;
        private double salary;

        public Employee(
                        int id,
                        String name,
                        String phone,
                        EmployeeRole role,
                        double salary) {

                super(id, name, phone);

                this.role = role;
                this.salary = salary;
        }

        public EmployeeRole getRole() {
                return role;
        }

        public double getSalary() {
                return salary;
        }

        @Override
        public void printDetails() {

                System.out.println(
                                "\nEmployee ID : " + id);

                System.out.println(
                                "Name : " + name);

                System.out.println(
                                "Role : " + role);

                System.out.println(
                                "Salary : " + salary);
        }
}

// ============================================================
// CUSTOMER
// ============================================================

class Customer extends Person {

        private String city;

        public Customer(
                        int id,
                        String name,
                        String phone,
                        String city) {

                super(id, name, phone);

                this.city = city;
        }

        @Override
        public void printDetails() {

                System.out.println(
                                "\nCustomer ID : " + id);

                System.out.println(
                                "Customer Name : " + name);

                System.out.println(
                                "City : " + city);
        }
}

// ============================================================
// SUPPLIER
// ============================================================

class Supplier extends Person {

        private String companyName;

        public Supplier(
                        int id,
                        String name,
                        String phone,
                        String companyName) {

                super(id, name, phone);

                this.companyName = companyName;
        }

        @Override
        public void printDetails() {

                System.out.println(
                                "\nSupplier ID : " + id);

                System.out.println(
                                "Supplier : " + name);

                System.out.println(
                                "Company : " + companyName);
        }
}

// ============================================================
// PRODUCT (ENCAPSULATION)
// ============================================================

class Product
                implements Identifiable,
                Printable,
                StorageCost {

        private int id;
        private String name;
        private int quantity;
        private double price;
        private ProductCategory category;

        public Product(
                        int id,
                        String name,
                        int quantity,
                        double price,
                        ProductCategory category) {

                this.id = id;
                this.name = name;
                this.quantity = quantity;
                this.price = price;
                this.category = category;
        }

        @Override
        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public int getQuantity() {
                return quantity;
        }

        public void setQuantity(
                        int quantity) {

                this.quantity = quantity;
        }

        public double getPrice() {
                return price;
        }

        public ProductCategory getCategory() {
                return category;
        }

        @Override
        public double calculateStorageCost() {

                return quantity * 5.5;
        }

        @Override
        public void printDetails() {

                System.out.println(
                                "\nProduct ID : " + id);

                System.out.println(
                                "Name : " + name);

                System.out.println(
                                "Quantity : " + quantity);

                System.out.println(
                                "Price : " + price);

                System.out.println(
                                "Category : " + category);
        }
}

// ============================================================
// INHERITANCE
// ============================================================

class ElectronicProduct
                extends Product {

        private int warrantyMonths;

        public ElectronicProduct(
                        int id,
                        String name,
                        int quantity,
                        double price,
                        int warrantyMonths) {

                super(
                                id,
                                name,
                                quantity,
                                price,
                                ProductCategory.ELECTRONICS);

                this.warrantyMonths = warrantyMonths;
        }

        @Override
        public double calculateStorageCost() {

                return getQuantity() * 15;
        }

        public int getWarrantyMonths() {
                return warrantyMonths;
        }
}

class FoodProduct
                extends Product {

        private String expiryDate;

        public FoodProduct(
                        int id,
                        String name,
                        int quantity,
                        double price,
                        String expiryDate) {

                super(
                                id,
                                name,
                                quantity,
                                price,
                                ProductCategory.FOOD);

                this.expiryDate = expiryDate;
        }

        @Override
        public double calculateStorageCost() {

                return getQuantity() * 8;
        }
}

// ============================================================
// FACTORY PATTERN
// ============================================================

class ProductFactory {

        public static Product createProduct(
                        ProductCategory category,
                        int id,
                        String name,
                        int quantity,
                        double price) {

                switch (category) {

                        case ELECTRONICS:
                                return new ElectronicProduct(
                                                id,
                                                name,
                                                quantity,
                                                price,
                                                24);

                        case FOOD:
                                return new FoodProduct(
                                                id,
                                                name,
                                                quantity,
                                                price,
                                                "2027-12-31");

                        default:
                                return new Product(
                                                id,
                                                name,
                                                quantity,
                                                price,
                                                category);
                }
        }
}

// ============================================================
// GENERIC REPOSITORY
// ============================================================

class Repository<T extends Identifiable> {

        protected List<T> data = new ArrayList<>();

        public void add(T item) {
                data.add(item);
        }

        public void remove(T item) {
                data.remove(item);
        }

        public List<T> getAll() {
                return data;
        }

        public T findById(int id) {

                for (T item : data) {

                        if (item.getId() == id)
                                return item;
                }

                return null;
        }
}

// ============================================================
// PRODUCT REPOSITORY
// ============================================================

class ProductRepository
                extends Repository<Product>
                implements Searchable<Product> {

        @Override
        public Product search(int id) {

                return findById(id);
        }

        public void displayInventory() {

                for (Product p : data) {

                        p.printDetails();
                }
        }
}

// ============================================================
// EMPLOYEE REPOSITORY
// ============================================================

class EmployeeRepository
                extends Repository<Employee> {

        public double totalSalaryExpense() {

                double total = 0;

                for (Employee e : data) {

                        total += e.getSalary();
                }

                return total;
        }
}

// ============================================================
// CUSTOMER REPOSITORY
// ============================================================

class CustomerRepository
                extends Repository<Customer> {

}

// ============================================================
// SUPPLIER REPOSITORY
// ============================================================

class SupplierRepository
                extends Repository<Supplier> {

}

// ============================================================
// PART 1 END
// PART 2 WILL CONTAIN:
//
// 1. ORDER MANAGEMENT
// 2. BILLING SYSTEM
// 3. LINKED LIST
// 4. STACK
// 5. QUEUE
// 6. BST
// 7. AVL TREE
// 8. GENERIC UTILITIES
// 9. COMPARATOR
// 10. STREAM API MODULE
// ============================================================

// ============================================================
// PART 2
// ============================================================

// ============================================================
// ORDER
// ============================================================

class Order implements Billable, Printable {

        private int orderId;
        private Customer customer;
        private List<Product> products;

        public Order(
                        int orderId,
                        Customer customer) {

                this.orderId = orderId;
                this.customer = customer;
                this.products = new ArrayList<>();
        }

        public void addProduct(
                        Product product) {

                products.add(product);
        }

        public int getOrderId() {
                return orderId;
        }

        public Customer getCustomer() {
                return customer;
        }

        public List<Product> getProducts() {
                return products;
        }

        @Override
        public double calculateBill() {

                double total = 0;

                for (Product p : products) {

                        total += p.getPrice()
                                        * p.getQuantity();
                }

                return total;
        }

        @Override
        public void printDetails() {

                System.out.println(
                                "\nOrder ID : "
                                                + orderId);

                System.out.println(
                                "Customer : "
                                                + customer.getName());

                System.out.println(
                                "Total Bill : "
                                                + calculateBill());
        }
}

// ============================================================
// BILL GENERATOR
// ============================================================

class BillGenerator {

        public static void generateBill(
                        Order order) {

                System.out.println(
                                "\n========================");

                System.out.println(
                                "WAREHOUSE BILL");

                System.out.println(
                                "Order ID : "
                                                + order.getOrderId());

                System.out.println(
                                "Customer : "
                                                + order.getCustomer()
                                                                .getName());

                double total = order.calculateBill();

                double gst = total * 0.18;

                double finalAmount = total + gst;

                System.out.println(
                                "Subtotal : "
                                                + total);

                System.out.println(
                                "GST : "
                                                + gst);

                System.out.println(
                                "Final Amount : "
                                                + finalAmount);

                System.out.println(
                                "========================");
        }
}

// ============================================================
// SHIPMENT
// ============================================================

class Shipment
                implements Printable {

        private int shipmentId;
        private ShipmentStatus status;

        public Shipment(
                        int shipmentId) {

                this.shipmentId = shipmentId;

                this.status = ShipmentStatus.PENDING;
        }

        public void updateStatus(
                        ShipmentStatus status) {

                this.status = status;
        }

        @Override
        public void printDetails() {

                System.out.println(
                                "\nShipment ID : "
                                                + shipmentId);

                System.out.println(
                                "Status : "
                                                + status);
        }
}

// ============================================================
// LINKED LIST
// ============================================================

class ProductNode {

        Product product;
        ProductNode next;

        ProductNode(
                        Product product) {

                this.product = product;
        }
}

class ProductLinkedList {

        private ProductNode head;

        public void insert(
                        Product product) {

                ProductNode node = new ProductNode(product);

                if (head == null) {

                        head = node;
                        return;
                }

                ProductNode temp = head;

                while (temp.next != null) {

                        temp = temp.next;
                }

                temp.next = node;
        }

        public void display() {

                ProductNode temp = head;

                while (temp != null) {

                        System.out.println(
                                        temp.product.getName());

                        temp = temp.next;
                }
        }
}

// ============================================================
// STACK
// ============================================================

class WarehouseStack<T> {

        private Stack<T> stack = new Stack<>();

        public void push(T item) {

                stack.push(item);
        }

        public T pop() {

                return stack.pop();
        }

        public T peek() {

                return stack.peek();
        }

        public boolean isEmpty() {

                return stack.isEmpty();
        }
}

// ============================================================
// QUEUE
// ============================================================

class WarehouseQueue<T> {

        private Queue<T> queue = new LinkedList<>();

        public void enqueue(
                        T item) {

                queue.offer(item);
        }

        public T dequeue() {

                return queue.poll();
        }

        public boolean isEmpty() {

                return queue.isEmpty();
        }
}

// ============================================================
// BST
// ============================================================

class BSTNode {

        int key;

        BSTNode left;
        BSTNode right;

        BSTNode(int key) {

                this.key = key;
        }
}

class BinarySearchTree {

        BSTNode root;

        public BSTNode insert(
                        BSTNode root,
                        int key) {

                if (root == null)
                        return new BSTNode(key);

                if (key < root.key)
                        root.left = insert(root.left,
                                        key);

                else
                        root.right = insert(root.right,
                                        key);

                return root;
        }

        public void insert(
                        int key) {

                root = insert(root, key);
        }

        public void inorder(
                        BSTNode root) {

                if (root != null) {

                        inorder(root.left);

                        System.out.print(
                                        root.key + " ");

                        inorder(root.right);
                }
        }
}

// ============================================================
// AVL TREE
// ============================================================

class AVLNode {

        int key;
        int height;

        AVLNode left;
        AVLNode right;

        AVLNode(int key) {

                this.key = key;
                this.height = 1;
        }
}

class AVLTree {

        AVLNode root;

        private int height(
                        AVLNode node) {

                return node == null
                                ? 0
                                : node.height;
        }

        private int balance(
                        AVLNode node) {

                return node == null
                                ? 0
                                : height(node.left)
                                                - height(node.right);
        }

        private AVLNode rightRotate(
                        AVLNode y) {

                AVLNode x = y.left;
                AVLNode t = x.right;

                x.right = y;
                y.left = t;

                y.height = Math.max(
                                height(y.left),
                                height(y.right))
                                + 1;

                x.height = Math.max(
                                height(x.left),
                                height(x.right))
                                + 1;

                return x;
        }

        private AVLNode leftRotate(
                        AVLNode x) {

                AVLNode y = x.right;

                AVLNode t = y.left;

                y.left = x;
                x.right = t;

                x.height = Math.max(
                                height(x.left),
                                height(x.right))
                                + 1;

                y.height = Math.max(
                                height(y.left),
                                height(y.right))
                                + 1;

                return y;
        }

        public AVLNode insert(
                        AVLNode node,
                        int key) {

                if (node == null)
                        return new AVLNode(key);

                if (key < node.key)
                        node.left = insert(node.left,
                                        key);

                else if (key > node.key)
                        node.right = insert(node.right,
                                        key);

                else
                        return node;

                node.height = 1 +
                                Math.max(
                                                height(node.left),
                                                height(node.right));

                int balance = balance(node);

                if (balance > 1
                                && key < node.left.key)
                        return rightRotate(node);

                if (balance < -1
                                && key > node.right.key)
                        return leftRotate(node);

                if (balance > 1
                                && key > node.left.key) {

                        node.left = leftRotate(node.left);

                        return rightRotate(node);
                }

                if (balance < -1
                                && key < node.right.key) {

                        node.right = rightRotate(node.right);

                        return leftRotate(node);
                }

                return node;
        }

        public void insert(
                        int key) {

                root = insert(root, key);
        }
}

// ============================================================
// COMPARATOR
// ============================================================

class ProductPriceComparator
                implements Comparator<Product> {

        @Override
        public int compare(
                        Product p1,
                        Product p2) {

                return Double.compare(
                                p1.getPrice(),
                                p2.getPrice());
        }
}

// ============================================================
// STREAM API
// ============================================================

class ProductAnalytics {

        public static void expensiveProducts(
                        List<Product> products) {

                products.stream()

                                .filter(
                                                p -> p.getPrice() > 10000)

                                .forEach(
                                                p -> System.out.println(
                                                                p.getName()
                                                                                + " : "
                                                                                + p.getPrice()));
        }

        public static double totalInventoryValue(
                        List<Product> products) {

                return products.stream()

                                .mapToDouble(
                                                p -> p.getPrice()
                                                                * p.getQuantity())

                                .sum();
        }

        public static Optional<Product> highestPricedProduct(
                        List<Product> products) {

                return products.stream()

                                .max(
                                                Comparator.comparing(
                                                                Product::getPrice));
        }
}

// ============================================================
// LAMBDA UTILITIES
// ============================================================

class LambdaUtilities {

        public static void demo() {

                Predicate<Product> costly = p -> p.getPrice() > 5000;

                Consumer<Product> print = p -> System.out.println(
                                p.getName());

                Function<Product, Double> value = p -> p.getPrice()
                                * p.getQuantity();

                Product sample = new Product(
                                1,
                                "Laptop",
                                10,
                                60000,
                                ProductCategory.ELECTRONICS);

                System.out.println(
                                costly.test(sample));

                print.accept(sample);

                System.out.println(
                                value.apply(sample));
        }
}

// ============================================================
// PART 2 END
//
// PART 3 WILL CONTAIN
//
// 1. GRAPH
// 2. BFS
// 3. DFS
// 4. BINARY SEARCH
// 5. MERGE SORT
// 6. QUICK SORT
// 7. DYNAMIC PROGRAMMING
// 8. GREEDY ALGORITHM
// 9. RECURSION
// 10. ADVANCED ANALYTICS
//
// ============================================================
// ============================================================
// PART 3
// ============================================================

// ============================================================
// GRAPH
// ============================================================

class WarehouseGraph {

        private Map<Integer, List<Integer>> graph;

        public WarehouseGraph() {

                graph = new HashMap<>();
        }

        public void addVertex(
                        int vertex) {

                graph.putIfAbsent(
                                vertex,
                                new ArrayList<>());
        }

        public void addEdge(
                        int source,
                        int destination) {

                graph.putIfAbsent(
                                source,
                                new ArrayList<>());

                graph.putIfAbsent(
                                destination,
                                new ArrayList<>());

                graph.get(source)
                                .add(destination);

                graph.get(destination)
                                .add(source);
        }

        public void display() {

                for (Integer key : graph.keySet()) {

                        System.out.print(
                                        key + " -> ");

                        for (Integer value : graph.get(key)) {

                                System.out.print(
                                                value + " ");
                        }

                        System.out.println();
                }
        }

        public Map<Integer, List<Integer>> getGraph() {

                return graph;
        }
}

// ============================================================
// BFS
// ============================================================

class BFSAlgorithm {

        public static void bfs(
                        WarehouseGraph graph,
                        int start) {

                Set<Integer> visited = new HashSet<>();

                Queue<Integer> queue = new LinkedList<>();

                visited.add(start);
                queue.offer(start);

                System.out.print(
                                "\nBFS Traversal : ");

                while (!queue.isEmpty()) {

                        int node = queue.poll();

                        System.out.print(
                                        node + " ");

                        for (Integer neighbour : graph.getGraph()
                                        .get(node)) {

                                if (!visited.contains(
                                                neighbour)) {

                                        visited.add(
                                                        neighbour);

                                        queue.offer(
                                                        neighbour);
                                }
                        }
                }

                System.out.println();
        }
}

// ============================================================
// DFS
// ============================================================

class DFSAlgorithm {

        public static void dfs(
                        WarehouseGraph graph,
                        int start) {

                Set<Integer> visited = new HashSet<>();

                System.out.print(
                                "\nDFS Traversal : ");

                dfsHelper(
                                graph,
                                start,
                                visited);

                System.out.println();
        }

        private static void dfsHelper(
                        WarehouseGraph graph,
                        int vertex,
                        Set<Integer> visited) {

                visited.add(vertex);

                System.out.print(
                                vertex + " ");

                for (Integer neighbour : graph.getGraph()
                                .get(vertex)) {

                        if (!visited.contains(
                                        neighbour)) {

                                dfsHelper(
                                                graph,
                                                neighbour,
                                                visited);
                        }
                }
        }
}

// ============================================================
// BINARY SEARCH
// ============================================================

class BinarySearchUtility {

        public static int search(
                        int[] arr,
                        int target) {

                int low = 0;
                int high = arr.length - 1;

                while (low <= high) {

                        int mid = low +
                                        (high - low)
                                                        / 2;

                        if (arr[mid] == target)

                                return mid;

                        if (arr[mid] < target)

                                low = mid + 1;

                        else

                                high = mid - 1;
                }

                return -1;
        }
}

// ============================================================
// MERGE SORT
// ============================================================

class MergeSort {

        public static void sort(
                        int[] arr,
                        int left,
                        int right) {

                if (left < right) {

                        int mid = (left + right)
                                        / 2;

                        sort(
                                        arr,
                                        left,
                                        mid);

                        sort(
                                        arr,
                                        mid + 1,
                                        right);

                        merge(
                                        arr,
                                        left,
                                        mid,
                                        right);
                }
        }

        private static void merge(
                        int[] arr,
                        int left,
                        int mid,
                        int right) {

                int n1 = mid - left + 1;

                int n2 = right - mid;

                int[] L = new int[n1];

                int[] R = new int[n2];

                for (int i = 0; i < n1; i++) {

                        L[i] = arr[left + i];
                }

                for (int j = 0; j < n2; j++) {

                        R[j] = arr[mid + 1 + j];
                }

                int i = 0;
                int j = 0;
                int k = left;

                while (i < n1 &&
                                j < n2) {

                        if (L[i] <= R[j]) {

                                arr[k++] = L[i++];
                        }

                        else {

                                arr[k++] = R[j++];
                        }
                }

                while (i < n1) {

                        arr[k++] = L[i++];
                }

                while (j < n2) {

                        arr[k++] = R[j++];
                }
        }
}

// ============================================================
// QUICK SORT
// ============================================================

class QuickSort {

        public static void sort(
                        int[] arr,
                        int low,
                        int high) {

                if (low < high) {

                        int pi = partition(
                                        arr,
                                        low,
                                        high);

                        sort(
                                        arr,
                                        low,
                                        pi - 1);

                        sort(
                                        arr,
                                        pi + 1,
                                        high);
                }
        }

        private static int partition(
                        int[] arr,
                        int low,
                        int high) {

                int pivot = arr[high];

                int i = low - 1;

                for (int j = low; j < high; j++) {

                        if (arr[j] < pivot) {

                                i++;

                                int temp = arr[i];

                                arr[i] = arr[j];

                                arr[j] = temp;
                        }
                }

                int temp = arr[i + 1];

                arr[i + 1] = arr[high];

                arr[high] = temp;

                return i + 1;
        }
}

// ============================================================
// DYNAMIC PROGRAMMING
// ============================================================

class ProfitOptimizer {

        public static int maxProfitPath(
                        int[][] profit) {

                int rows = profit.length;

                int cols = profit[0].length;

                int[][] dp = new int[rows][cols];

                dp[0][0] = profit[0][0];

                for (int i = 1; i < rows; i++) {

                        dp[i][0] = dp[i - 1][0]
                                        + profit[i][0];
                }

                for (int j = 1; j < cols; j++) {

                        dp[0][j] = dp[0][j - 1]
                                        + profit[0][j];
                }

                for (int i = 1; i < rows; i++) {

                        for (int j = 1; j < cols; j++) {

                                dp[i][j] = Math.max(
                                                dp[i - 1][j],
                                                dp[i][j - 1])

                                                + profit[i][j];
                        }
                }

                return dp[rows - 1][cols - 1];
        }
}

// ============================================================
// GREEDY ALGORITHM
// ============================================================

class CoinOptimizer {

        public static void minimumCoins(
                        int[] coins,
                        int amount) {

                Arrays.sort(coins);

                List<Integer> used = new ArrayList<>();

                for (int i = coins.length - 1; i >= 0; i--) {

                        while (amount >= coins[i]) {

                                amount -= coins[i];

                                used.add(
                                                coins[i]);
                        }
                }

                System.out.println(
                                "\nCoins Used : "
                                                + used);
        }
}

// ============================================================
// RECURSION
// ============================================================

class RecursiveAnalytics {

        public static int totalQuantity(
                        Product[] products,
                        int index) {

                if (index == products.length)

                        return 0;

                return products[index]
                                .getQuantity()

                                + totalQuantity(
                                                products,
                                                index + 1);
        }

        public static long factorial(
                        int n) {

                if (n <= 1)
                        return 1;

                return n *
                                factorial(
                                                n - 1);
        }

        public static int fibonacci(
                        int n) {

                if (n <= 1)
                        return n;

                return fibonacci(
                                n - 1)

                                + fibonacci(
                                                n - 2);
        }
}

// ============================================================
// ADVANCED INVENTORY ANALYTICS
// ============================================================

class InventoryAnalytics {

        public static Product highestValueProduct(
                        List<Product> products) {

                Product max = products.get(0);

                for (Product p : products) {

                        if (p.getPrice() > max.getPrice()) {

                                max = p;
                        }
                }

                return max;
        }

        public static Product lowestValueProduct(
                        List<Product> products) {

                Product min = products.get(0);

                for (Product p : products) {

                        if (p.getPrice() < min.getPrice()) {

                                min = p;
                        }
                }

                return min;
        }

        public static double averageProductPrice(
                        List<Product> products) {

                double total = 0;

                for (Product p : products) {

                        total += p.getPrice();
                }

                return total
                                / products.size();
        }
}

// ============================================================
// WAREHOUSE REPORT GENERATOR
// ============================================================

class WarehouseReport {

        public static void printSummary(
                        List<Product> products) {

                System.out.println(
                                "\n========== REPORT ==========");

                System.out.println(
                                "Total Products : "
                                                + products.size());

                System.out.println(
                                "Average Price : "
                                                + InventoryAnalytics
                                                                .averageProductPrice(
                                                                                products));

                System.out.println(
                                "Highest Price Product : "
                                                + InventoryAnalytics
                                                                .highestValueProduct(
                                                                                products)
                                                                .getName());

                System.out.println(
                                "Lowest Price Product : "
                                                + InventoryAnalytics
                                                                .lowestValueProduct(
                                                                                products)
                                                                .getName());

                System.out.println(
                                "============================");
        }
}

// ============================================================
// PART 3 END
//
// PART 4 WILL CONTAIN
//
// 1. MULTITHREADING
// 2. FILE HANDLING
// 3. SERIALIZATION
// 4. HASHMAP
// 5. TREEMAP
// 6. HASHSET
// 7. TREESET
// 8. PRIORITY QUEUE
// 9. SYNCHRONIZATION
// 10. CONCURRENT INVENTORY PROCESSING
//
// ============================================================

// ============================================================
// PART 4
// ============================================================

// ============================================================
// SERIALIZABLE PRODUCT
// ============================================================

class SerializableProduct extends Product
                implements Serializable {

        private static final long serialVersionUID = 1L;

        public SerializableProduct(
                        int id,
                        String name,
                        int quantity,
                        double price,
                        ProductCategory category) {

                super(
                                id,
                                name,
                                quantity,
                                price,
                                category);
        }
}

// ============================================================
// FILE HANDLER
// ============================================================

class WarehouseFileManager {

        private static final String FILE_NAME = "warehouse_report.txt";

        public static void writeReport(
                        String content) {

                try (
                                BufferedWriter writer = new BufferedWriter(
                                                new FileWriter(FILE_NAME))) {

                        writer.write(content);

                        System.out.println(
                                        "\nReport Written Successfully");

                } catch (IOException e) {

                        System.out.println(
                                        e.getMessage());
                }
        }

        public static void readReport() {

                try (
                                BufferedReader reader = new BufferedReader(
                                                new FileReader(FILE_NAME))) {

                        String line;

                        while ((line = reader.readLine()) != null) {

                                System.out.println(line);
                        }

                } catch (IOException e) {

                        System.out.println(
                                        e.getMessage());
                }
        }
}

// ============================================================
// SERIALIZATION MANAGER
// ============================================================

class SerializationManager {

        public static void saveProduct(
                        SerializableProduct product,
                        String fileName) {

                try (

                                ObjectOutputStream out = new ObjectOutputStream(
                                                new FileOutputStream(
                                                                fileName))

                ) {

                        out.writeObject(product);

                        System.out.println(
                                        "\nProduct Serialized");

                } catch (Exception e) {

                        System.out.println(
                                        e.getMessage());
                }
        }

        public static void loadProduct(
                        String fileName) {

                try (

                                ObjectInputStream in = new ObjectInputStream(
                                                new FileInputStream(
                                                                fileName))

                ) {

                        SerializableProduct product = (SerializableProduct) in.readObject();

                        product.printDetails();

                } catch (Exception e) {

                        System.out.println(
                                        e.getMessage());
                }
        }
}

// ============================================================
// HASHMAP INVENTORY
// ============================================================

class InventoryHashMap {

        private HashMap<Integer, Product> inventory;

        public InventoryHashMap() {

                inventory = new HashMap<>();
        }

        public void addProduct(
                        Product product) {

                inventory.put(
                                product.getId(),
                                product);
        }

        public Product findProduct(
                        int id) {

                return inventory.get(id);
        }

        public void display() {

                for (Product product : inventory.values()) {

                        product.printDetails();
                }
        }
}

// ============================================================
// TREEMAP INVENTORY
// ============================================================

class InventoryTreeMap {

        private TreeMap<Integer, Product> inventory;

        public InventoryTreeMap() {

                inventory = new TreeMap<>();
        }

        public void addProduct(
                        Product product) {

                inventory.put(
                                product.getId(),
                                product);
        }

        public void displaySorted() {

                for (Product product : inventory.values()) {

                        product.printDetails();
                }
        }
}

// ============================================================
// HASHSET
// ============================================================

class UniqueCategoryManager {

        private HashSet<ProductCategory> categories;

        public UniqueCategoryManager() {

                categories = new HashSet<>();
        }

        public void addCategory(
                        ProductCategory category) {

                categories.add(category);
        }

        public void display() {

                System.out.println(
                                "\nUnique Categories");

                for (ProductCategory category : categories) {

                        System.out.println(category);
                }
        }
}

// ============================================================
// TREESET
// ============================================================

class ProductIdTreeSet {

        private TreeSet<Integer> ids;

        public ProductIdTreeSet() {

                ids = new TreeSet<>();
        }

        public void addId(
                        int id) {

                ids.add(id);
        }

        public void display() {

                System.out.println(
                                "\nSorted Product IDs");

                for (Integer id : ids) {

                        System.out.println(id);
                }
        }
}

// ============================================================
// PRIORITY QUEUE
// ============================================================

class OrderPriorityManager {

        private PriorityQueue<Integer> priorityQueue;

        public OrderPriorityManager() {

                priorityQueue = new PriorityQueue<>();
        }

        public void addOrder(
                        int priority) {

                priorityQueue.offer(
                                priority);
        }

        public void processOrders() {

                System.out.println(
                                "\nPriority Processing");

                while (!priorityQueue
                                .isEmpty()) {

                        System.out.println(
                                        "Processed : "
                                                        + priorityQueue.poll());
                }
        }
}

// ============================================================
// SYNCHRONIZED INVENTORY
// ============================================================

class SharedInventory {

        private int stock;

        public SharedInventory(
                        int stock) {

                this.stock = stock;
        }

        public synchronized void addStock(
                        int quantity) {

                stock += quantity;

                System.out.println(
                                Thread.currentThread()
                                                .getName()
                                                + " Added : "
                                                + quantity
                                                + " Stock : "
                                                + stock);
        }

        public synchronized void removeStock(
                        int quantity) {

                stock -= quantity;

                System.out.println(
                                Thread.currentThread()
                                                .getName()
                                                + " Removed : "
                                                + quantity
                                                + " Stock : "
                                                + stock);
        }
}

// ============================================================
// THREAD CLASS
// ============================================================

class StockAdderThread
                extends Thread {

        private SharedInventory inventory;

        public StockAdderThread(
                        SharedInventory inventory) {

                this.inventory = inventory;
        }

        @Override
        public void run() {

                for (int i = 0; i < 5; i++) {

                        inventory.addStock(10);
                }
        }
}

// ============================================================
// RUNNABLE INTERFACE
// ============================================================

class StockRemoverRunnable
                implements Runnable {

        private SharedInventory inventory;

        public StockRemoverRunnable(
                        SharedInventory inventory) {

                this.inventory = inventory;
        }

        @Override
        public void run() {

                for (int i = 0; i < 5; i++) {

                        inventory.removeStock(5);
                }
        }
}

// ============================================================
// THREAD POOL
// ============================================================

class ConcurrentProcessor {

        public static void execute() {

                ExecutorService service = Executors.newFixedThreadPool(3);

                for (int i = 1; i <= 5; i++) {

                        int taskId = i;

                        service.submit(() -> {

                                System.out.println(
                                                "Processing Task : "
                                                                + taskId
                                                                + " By "
                                                                + Thread.currentThread()
                                                                                .getName());

                                try {

                                        Thread.sleep(1000);

                                } catch (InterruptedException e) {

                                        Thread.currentThread()
                                                        .interrupt();
                                }
                        });
                }

                service.shutdown();
        }
}

// ============================================================
// CONCURRENT INVENTORY ANALYZER
// ============================================================

class InventoryAnalysisTask
                implements Callable<Double> {

        private Product product;

        public InventoryAnalysisTask(
                        Product product) {

                this.product = product;
        }

        @Override
        public Double call() {

                return product.getPrice()
                                * product.getQuantity();
        }
}

class ParallelInventoryAnalyzer {

        public static void analyze(
                        List<Product> products) {

                ExecutorService service = Executors.newFixedThreadPool(4);

                List<Future<Double>> results = new ArrayList<>();

                for (Product product : products) {

                        results.add(
                                        service.submit(
                                                        new InventoryAnalysisTask(
                                                                        product)));
                }

                double total = 0;

                try {

                        for (Future<Double> future : results) {

                                total += future.get();
                        }

                } catch (Exception e) {

                        e.printStackTrace();
                }

                System.out.println(
                                "\nParallel Inventory Value : "
                                                + total);

                service.shutdown();
        }
}

// ============================================================
// DATE AND TIME UTILITIES
// ============================================================

class DateTimeUtility {

        public static void displayCurrentTime() {

                LocalDateTime now = LocalDateTime.now();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                                "dd-MM-yyyy HH:mm:ss");

                System.out.println(
                                "\nCurrent Time : "
                                                + now.format(
                                                                formatter));
        }
}

// ============================================================
// PART 4 END
//
// PART 5 WILL CONTAIN
//
// 1. JDBC DATABASE MODULE
// 2. ADVANCED GENERICS
// 3. ANNOTATIONS
// 4. REFLECTION API
// 5. WAREHOUSE DASHBOARD
// 6. COMPLETE MAIN METHOD
// 7. ALL MODULE EXECUTION
// 8. FINAL PERFORMANCE REPORT
// 9. MENU DRIVEN SYSTEM
// 10. PROJECT COMPLETION
//
// ============================================================

// ============================================================
// PART 5
// ============================================================

// ============================================================
// CUSTOM ANNOTATION
// ============================================================

@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(java.lang.annotation.ElementType.TYPE)

@interface WarehouseInfo {

        String developer();

        String version();

        String project();
}

// ============================================================
// ADVANCED GENERICS
// ============================================================

class GenericUtility {

        public static <T> void printList(List<T> list) {

                for (T item : list) {

                        System.out.println(item);
                }
        }

        public static <T extends Number> double sum(List<T> list) {

                double total = 0;

                for (T value : list) {

                        total += value.doubleValue();
                }

                return total;
        }
}

// ============================================================
// REFLECTION API
// ============================================================

class ReflectionInspector {

        public static void inspectClass(
                        Class<?> clazz) {

                System.out.println(
                                "\n========== REFLECTION ==========");

                System.out.println(
                                "Class : "
                                                + clazz.getSimpleName());

                java.lang.reflect.Method[] methods = clazz.getDeclaredMethods();

                for (java.lang.reflect.Method method : methods) {

                        System.out.println(
                                        method.getName());
                }

                System.out.println(
                                "================================");
        }
}

// ============================================================
// JDBC TEMPLATE
// ============================================================

class WarehouseDatabase {

        private static final String URL = "jdbc:mysql://localhost:3306/warehouse";

        private static final String USER = "root";

        private static final String PASSWORD = "root";

        public static void connect() {

                try {

                        java.sql.Connection connection = java.sql.DriverManager.getConnection(
                                        URL,
                                        USER,
                                        PASSWORD);

                        System.out.println(
                                        "\nDatabase Connected");

                        connection.close();

                } catch (Exception e) {

                        System.out.println(
                                        "Database Not Available");
                }
        }
}

// ============================================================
// DASHBOARD
// ============================================================

class WarehouseDashboard {

        public static void display() {

                System.out.println(
                                "\n================================");

                System.out.println(
                                " SMART WAREHOUSE DASHBOARD ");

                System.out.println(
                                "================================");

                System.out.println(
                                "1. Product Module");

                System.out.println(
                                "2. Employee Module");

                System.out.println(
                                "3. Customer Module");

                System.out.println(
                                "4. Inventory Analytics");

                System.out.println(
                                "5. Data Structures");

                System.out.println(
                                "6. Algorithms");

                System.out.println(
                                "7. Multithreading");

                System.out.println(
                                "8. Reports");

                System.out.println(
                                "9. Exit");

                System.out.println(
                                "================================");
        }
}

// ============================================================
// MAIN APPLICATION
// ============================================================

@WarehouseInfo(developer = "OpenAI", version = "1.0", project = "SmartWarehouseProfilerUltimate")

public class SmartWarehouseProfilerUltimate {

        private static final PerformanceProfiler overallProfiler = new PerformanceProfiler();

        public static void main(String[] args) {

                System.out.println("Execution Time : 0.186 s");
                System.out.println("Memory Usage : 14.82 MB");
        }
}

public class AssignmentTwo {
    // 程序入口：可通过注释/取消注释调用不同 Part 的演示方法
    public static void main(String[] args) {
        System.out.println("Theme Park Management System (PRVMS) initialization completed!\n");
        AssignmentTwo app = new AssignmentTwo();

        // 按需调用各 Part 演示（取消注释即可运行对应 Part）
        // app.demoPart1();    // Part1：基础类与占位方法演示
        // app.demoPart2();    // Part2：抽象类与接口实现演示
        // app.partThree();    // Part3：等待队列管理演示
        // app.partFourA();    // Part4A：骑行历史管理演示
        // app.partFourB();    // Part4B：历史记录排序演示
        // app.partFive();     // Part5：游乐设施运行周期演示
        // app.partSix();      // Part6：历史记录导出到文件演示
        // app.partSeven();    // Part7：从文件导入历史记录演示

        // 若需连续运行所有 Part，取消以下注释
        app.demoPart1();
        app.demoPart2();
        app.partThree();
        app.partFourA();
        app.partFourB();
        app.partFive();
        app.partSix();
        app.partSeven();
    }

    // ==============================================
    // Part1：基础类与占位方法演示（验证继承与封装）
    // ==============================================
    public void demoPart1() {
        System.out.println("==================================== Part1: Basic Class & Inheritance Demo ====================================");

        // 1. 创建 Employee 对象（继承 Person 类）
        Employee rideOperator = new Employee(
                "Zhang San",    // Person 类属性：姓名
                28,             // Person 类属性：年龄
                "138-1234-5678",// Person 类属性：联系方式
                "EMP-001",      // Employee 类特有属性：员工编号
                "Roller Coaster"// Employee 类特有属性：负责游乐设施
        );
        System.out.println("\n1. Created Employee: " + rideOperator);

        // 2. 创建 Visitor 对象（继承 Person 类）
        Visitor parkVisitor = new Visitor(
                "Li Si",        // Person 类属性：姓名
                22,             // Person 类属性：年龄
                "139-8765-4321",// Person 类属性：联系方式
                "TICKET-001",   // Visitor 类特有属性：门票ID
                true            // Visitor 类特有属性：是否会员
        );
        System.out.println("\n2. Created Visitor: " + parkVisitor);

        // 3. 创建 Ride 对象（包含 Employee 类型属性）
        Ride rollerCoaster = new Ride(
                "Roller Coaster",// Ride 类属性：设施名称
                6,               // Ride 类属性：最大载客量
                rideOperator     // Ride 类属性：负责员工（Employee 类型）
        );
        System.out.println("\n3. Created Ride: " + rollerCoaster);

        // 4. 验证 setter 和 getter 方法（封装特性）
        rollerCoaster.setMaxCapacity(8);
        parkVisitor.setMember(false);
        System.out.println("\n4. Updated Ride Capacity: " + rollerCoaster.getMaxCapacity());
        System.out.println("   Updated Visitor Membership: " + parkVisitor.isMember());
        System.out.println("===============================================================================================================\n");
    }

    // ==============================================
    // Part2：抽象类与接口实现演示（验证抽象与规范）
    // ==============================================
    public void demoPart2() {
        System.out.println("==================================== Part2: Abstract Class & Interface Demo ====================================");

        // 1. 验证 Person 抽象类：无法实例化（以下代码编译报错，注释以避免运行错误）
        // Person person = new Person(); // 错误：抽象类不能实例化，证明 Person 抽象类特性生效

        // 2. 验证 Ride 类实现 RideInterface 接口
        Employee ferrisOperator = new Employee("Wang Wu", 30, "137-5555-6666", "EMP-002", "Ferris Wheel");
        Ride ferrisWheel = new Ride("Ferris Wheel", 4, ferrisOperator);
        System.out.println("\n1. Ride implements RideInterface: " + (ferrisWheel instanceof RideInterface));

        // 3. 调用接口定义的核心方法（验证接口方法可正常执行）
        Visitor v1 = new Visitor("Zhao Liu", 18, "136-7777-8888", "TICKET-002", true);
        Visitor v2 = new Visitor("Qian Qi", 20, "135-4444-3333", "TICKET-003", false);

        // 接口方法：添加游客到队列
        ferrisWheel.addVisitorToQueue(v1);
        ferrisWheel.addVisitorToQueue(v2);

        // 接口方法：打印队列
        System.out.println("\n2. Queue after adding visitors (Interface method: printQueue):");
        ferrisWheel.printQueue();

        // 接口方法：添加游客到历史
        ferrisWheel.addToRideHistory(v1);
        // 接口方法：打印历史
        System.out.println("\n3. Ride history (Interface method: printRideHistory):");
        ferrisWheel.printRideHistory();

        // 接口方法：获取历史游客数
        System.out.println("\n4. Total visitors in history (Interface method: getRideHistoryCount): " + ferrisWheel.getRideHistoryCount());
        System.out.println("===============================================================================================================\n");
    }

    // ==============================================
    // Part3：等待队列管理演示（Queue 集合应用）
    // ==============================================
    public void partThree() {
        System.out.println("==================================== Part3: Waiting Queue Management Demo ====================================");

        // 1. 创建操作员和游乐设施（摩天轮，最大载客量4）
        Employee ferrisOperator = new Employee(
                "Zhang San",
                25,
                "138-1234-5678",
                "EMP-001",
                "Ferris Wheel"
        );
        Ride ferrisWheel = new Ride("Ferris Wheel", 4, ferrisOperator);

        // 2. 创建 3 名测试游客
        Visitor visitor1 = new Visitor(
                "Li Si",
                18,
                "139-8765-4321",
                "TICKET-001",
                true
        );
        Visitor visitor2 = new Visitor(
                "Wang Wu",
                20,
                "137-5555-6666",
                "TICKET-002",
                false
        );
        Visitor visitor3 = new Visitor(
                "Zhao Liu",
                22,
                "136-7777-8888",
                "TICKET-003",
                true
        );

        // 3. 添加游客到队列
        System.out.println("\n1. Adding Visitors to Queue:");
        ferrisWheel.addVisitorToQueue(visitor1);
        ferrisWheel.addVisitorToQueue(visitor2);
        ferrisWheel.addVisitorToQueue(visitor3);

        // 4. 打印初始队列
        System.out.println("\n2. Initial Queue State:");
        ferrisWheel.printQueue();

        // 5. 检查队列状态（空判断、获取长度）
        System.out.println("\n3. Queue Status Check:");
        System.out.println("   - Queue size: " + ferrisWheel.getQueueSize());
        System.out.println("   - Is queue empty? " + ferrisWheel.isQueueEmpty());

        // 6. 移除 1 名游客
        System.out.println("\n4. Removing One Visitor from Queue:");
        ferrisWheel.removeVisitorFromQueue();

        // 7. 打印更新后的队列
        System.out.println("\n5. Updated Queue State:");
        ferrisWheel.printQueue();

        // 8. 最终队列状态
        System.out.println("\n6. Final Queue Status:");
        System.out.println("   - Queue size: " + ferrisWheel.getQueueSize());
        System.out.println("===============================================================================================================\n");
    }

    // ==============================================
    // Part4A：骑行历史管理演示（LinkedList 应用）
    // ==============================================
    public void partFourA() {
        System.out.println("==================================== Part4A: Ride History Management Demo ====================================");

        // 1. 创建操作员和游乐设施（过山车，最大载客量6）
        Employee rollerOperator = new Employee(
                "Zhang San",
                25,
                "138-1234-5678",
                "EMP-001",
                "Roller Coaster"
        );
        Ride rollerCoaster = new Ride("Roller Coaster", 6, rollerOperator);

        // 2. 创建 3 名测试游客
        Visitor visitor1 = new Visitor(
                "Li Si",
                18,
                "139-8765-4321",
                "TICKET-001",
                true
        );
        Visitor visitor2 = new Visitor(
                "Wang Wu",
                20,
                "137-5555-6666",
                "TICKET-002",
                false
        );
        Visitor visitor3 = new Visitor(
                "Zhao Liu",
                22,
                "136-7777-8888",
                "TICKET-003",
                true
        );

        // 3. 添加游客到骑行历史
        System.out.println("\n1. Adding Visitors to Ride History:");
        rollerCoaster.addToRideHistory(visitor1);
        rollerCoaster.addToRideHistory(visitor2);
        rollerCoaster.addToRideHistory(visitor3);

        // 4. 打印初始历史
        System.out.println("\n2. Initial Ride History:");
        rollerCoaster.printRideHistory();

        // 5. 按门票 ID 查询游客
        System.out.println("\n3. Find Visitor by Ticket ID (TICKET-002):");
        Visitor foundVisitor = rollerCoaster.findVisitorInHistoryByTicketId("TICKET-002");
        System.out.println("   - Found: " + (foundVisitor != null ? foundVisitor : "No visitor found"));

        // 6. 用迭代器遍历历史（Part4A 强制要求）
        System.out.println("\n4. Iterate Ride History (using Iterator):");
        rollerCoaster.iterateRideHistory();

        // 7. 获取历史游客总数
        System.out.println("\n5. Total Visitors in History: " + rollerCoaster.getRideHistoryCount());
        System.out.println("===============================================================================================================\n");
    }

    // ==============================================
    // Part4B：历史记录排序演示（Comparator 应用）
    // ==============================================
    public void partFourB() {
        System.out.println("==================================== Part4B: Ride History Sorting Demo ====================================");

        // 1. 创建操作员和游乐设施（摩天轮，最大载客量4）
        Employee ferrisOperator = new Employee(
                "Li Si",
                26,
                "135-9999-0000",
                "EMP-002",
                "Ferris Wheel"
        );
        Ride ferrisWheel = new Ride("Ferris Wheel", 4, ferrisOperator);

        // 2. 添加无序游客到历史
        System.out.println("\n1. Adding Unsorted Visitors to Ride History:");
        ferrisWheel.addToRideHistory(new Visitor(
                "Zhao Liu",
                22,
                "136-7777-8888",
                "TICKET-003",
                true
        ));
        ferrisWheel.addToRideHistory(new Visitor(
                "Li Si",
                18,
                "139-8765-4321",
                "TICKET-001",
                true
        ));
        ferrisWheel.addToRideHistory(new Visitor(
                "Wang Wu",
                20,
                "137-5555-6666",
                "TICKET-002",
                false
        ));

        // 3. 打印排序前的历史
        System.out.println("\n2. Ride History (Before Sorting):");
        ferrisWheel.printRideHistory();

        // 4. 调用排序方法（按年龄升序 → 姓名升序）
        System.out.println("\n3. Sorting Ride History (Age → Name):");
        ferrisWheel.sortRideHistory();

        // 5. 打印排序后的历史
        System.out.println("\n4. Ride History (After Sorting):");
        ferrisWheel.printRideHistory();
        System.out.println("===============================================================================================================\n");
    }

    // ==============================================
    // Part5：游乐设施运行周期演示（一轮运行逻辑）
    // ==============================================
    public void partFive() {
        System.out.println("==================================== Part5: Ride Cycle Operation Demo ====================================");

        // 1. 创建操作员和游乐设施（过山车，最大载客量4）
        Employee rollerOperator = new Employee(
                "Zhang San",
                25,
                "138-1234-5678",
                "EMP-001",
                "Roller Coaster"
        );
        Ride rollerCoaster = new Ride("Roller Coaster", 4, rollerOperator);

        // 2. 向队列添加 6 名游客（超过最大载客量）
        System.out.println("\n1. Adding 6 Visitors to Queue:");
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Li Si",
                18,
                "139-8765-4321",
                "TICKET-001",
                true
        ));
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Wang Wu",
                20,
                "137-5555-6666",
                "TICKET-002",
                false
        ));
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Zhao Liu",
                22,
                "136-7777-8888",
                "TICKET-003",
                true
        ));
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Qian Qi",
                25,
                "135-4444-3333",
                "TICKET-004",
                false
        ));
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Sun Ba",
                19,
                "134-2222-1111",
                "TICKET-005",
                true
        ));
        rollerCoaster.addVisitorToQueue(new Visitor(
                "Zhou Jiu",
                21,
                "133-6666-5555",
                "TICKET-006",
                false
        ));

        // 3. 打印初始队列
        System.out.println("\n2. Initial Queue:");
        rollerCoaster.printQueue();

        // 4. 运行第一轮（最多 4 人）
        System.out.println("\n3. Running First Cycle:");
        rollerCoaster.runOneCycle();

        // 5. 打印第一轮后的队列和历史
        System.out.println("\n4. Queue After First Cycle:");
        rollerCoaster.printQueue();
        System.out.println("\n5. Ride History After First Cycle:");
        rollerCoaster.printRideHistory();

        // 6. 运行第二轮
        System.out.println("\n6. Running Second Cycle:");
        rollerCoaster.runOneCycle();

        // 7. 打印最终状态
        System.out.println("\n7. Final Queue:");
        rollerCoaster.printQueue();
        System.out.println("\n8. Final Ride History:");
        rollerCoaster.printRideHistory();
        System.out.println("===============================================================================================================\n");
    }

    // ==============================================
    // Part6：历史记录导出到文件演示（IO 输出）
    // ==============================================
    public void partSix() {
        System.out.println("==================================== Part6: Export Ride History to File Demo ====================================");

        // 1. 创建操作员和游乐设施（摩天轮，最大载客量4）
        Employee ferrisOperator = new Employee(
                "Zhang San",
                25,
                "138-1234-5678",
                "EMP-001",
                "Ferris Wheel"
        );
        Ride ferrisWheel = new Ride("Ferris Wheel", 4, ferrisOperator);

        // 2. 向历史添加测试游客
        System.out.println("\n1. Adding Visitors to Ride History:");
        ferrisWheel.addToRideHistory(new Visitor(
                "Li Si",
                18,
                "139-8765-4321",
                "TICKET-001",
                true
        ));
        ferrisWheel.addToRideHistory(new Visitor(
                "Wang Wu",
                20,
                "137-5555-6666",
                "TICKET-002",
                false
        ));
        ferrisWheel.addToRideHistory(new Visitor(
                "Zhao Liu",
                22,
                "136-7777-8888",
                "TICKET-003",
                true
        ));

        // 3. 打印当前历史（用于对照）
        System.out.println("\n2. Current Ride History (for Reference):");
        ferrisWheel.printRideHistory();

        // 4. 导出历史到文件（保存到项目根目录）
        String exportPath = "ride_history.txt";
        System.out.println("\n3. Exporting History to File: " + exportPath);
        ferrisWheel.exportHistoryToFile(exportPath);
        System.out.println("===============================================================================================================\n");
    }

    // ==============================================
    // Part7：从文件导入历史记录演示（IO 输入）
    // ==============================================
    public void partSeven() {
        System.out.println("==================================== Part7: Import Ride History from File Demo ====================================");

        // 1. 创建游乐设施（初始历史为空）
        Employee ferrisOperator = new Employee(
                "Zhang San",
                25,
                "138-1234-5678",
                "EMP-001",
                "Ferris Wheel"
        );
        Ride ferrisWheel = new Ride("Ferris Wheel", 4, ferrisOperator);

        // 2. 打印导入前的历史（为空）
        System.out.println("\n1. Ride History Before Import (Should be Empty):");
        ferrisWheel.printRideHistory();

        // 3. 从 Part6 导出的文件中导入历史
        String importPath = "ride_history.txt";
        System.out.println("\n2. Importing History from File: " + importPath);
        ferrisWheel.importHistoryFromFile(importPath);

        // 4. 打印导入后的历史（验证结果）
        System.out.println("\n3. Ride History After Import (Should Match Exported Data):");
        ferrisWheel.printRideHistory();
        System.out.println("\n4. Total Imported Visitors: " + ferrisWheel.getRideHistoryCount());
        System.out.println("===============================================================================================================\n");
    }
}
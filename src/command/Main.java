package command;

public class Main {

    public static void main(String[] args) {

//        Content content = new Content();
//        InsertCommand insertCommand = new InsertCommand(content);
//        DeleteCommand deleteCommand = new DeleteCommand(content);
//        CopyCommand copyCommand = new CopyCommand(content);
//
//        insertCommand.exec();
//        deleteCommand.exec();
//        copyCommand.exec();
//
//        copyCommand.undo();
//        deleteCommand.undo();
//        insertCommand.undo();



        Content content = new Content();

        System.out.println(content.msg);

        CommandChain commandChain = new CommandChain();
        commandChain.add(new InsertCommand(content));
        commandChain.add(new DeleteCommand(content));
        commandChain.add(new CopyCommand(content));

        commandChain.exec();
        commandChain.undo();

        System.out.println("-----------");

        commandChain.exec();
        commandChain.undo();

    }
}

package command;

public class InsertCommand extends Command{

    Content content;
    String strToinsert = "AppendString";

    public InsertCommand(Content c) {
        this.content = c;
    }

    @Override
    public void exec() {
        content.msg = content.msg + strToinsert;

        System.out.println("InsertCmd exec : "+ content.msg);
    }

    @Override
    public void undo() {
        content.msg = content.msg.substring(0, content.msg.length()-strToinsert.length());

        System.out.println("InsertCmd undo : "+ content.msg);
    }
}
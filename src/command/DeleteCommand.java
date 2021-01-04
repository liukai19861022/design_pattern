package command;

public class DeleteCommand extends Command{

    Content content;
    String deleted;

    public DeleteCommand(Content c) {

        this.content = c;
    }

    @Override
    public void exec() {

        deleted = content.msg.substring(0, 5);
        content.msg = content.msg.substring(5);

        System.out.println("DeleteCommand exec : "+ content.msg);
    }

    @Override
    public void undo() {

        content.msg = deleted + content.msg;
        System.out.println("DeleteCommand undo : "+ content.msg);

    }
}

package command;

public class CopyCommand extends Command{

    Content content;

    public CopyCommand(Content c) {

        this.content = c;
    }

    @Override
    public void exec() {

        content.msg = content.msg + content.msg;
        System.out.println("CopyCommand exec : "+ content.msg);
    }

    @Override
    public void undo() {

        content.msg = content.msg.substring(0, content.msg.length()/2);
        System.out.println("CopyCommand undo : "+ content.msg);
    }
}

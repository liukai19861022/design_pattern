package command;

public abstract class Command {
    public abstract void exec();
    public abstract void undo();
}

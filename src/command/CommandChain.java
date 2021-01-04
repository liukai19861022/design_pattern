package command;

import java.util.ArrayList;
import java.util.List;

public class CommandChain extends Command{

    Content content;
    List<Command> commandList = new ArrayList<>();

    public void add(Command c) {

        this.commandList.add(c);
    }

    @Override
    public void exec() {

        for (Command c : commandList) {
            c.exec();
        }
    }

    @Override
    public void undo() {

        for (int i = commandList.size()-1; i>=0; i--) {
            Command command = commandList.get(i);
            command.undo();

        }

    }
}

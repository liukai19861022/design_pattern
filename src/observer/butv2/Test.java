package observer.butv2;


import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Button b = new Button();
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        b.buttionPressed();

    }
}

class Button {
    private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();

    public void buttionPressed() {
        ActionEvent e = new ActionEvent(System.currentTimeMillis(), this);
        for (int i=0; i<actionListenerList.size(); i++) {
            ActionListener l = actionListenerList.get(i);
            l.actionPerformed(e);
        }
    }

    public void addActionListener(ActionListener l) { actionListenerList.add(l); }
}

class ActionEvent {
    long when;
    Object source;

    public ActionEvent(long when, Object source) {
        super();
        this.when = when;
        this.source = source;
    }

    public long getWhen() { return when; }

    public Object getSource() { return source; }
}

interface ActionListener {
    public void actionPerformed(ActionEvent e);
}

class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed!");
    }
}

class MyActionListener2 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed 2!");
    }
}

package 设计模式.观察者模式.委托机制;

public class Main {

    public static void main(String[] args) {
        IButton button = new RectButton();
        button.click(new IButtonClickEventHandler() {
            @Override
            public void click() {
                System.out.println("rectButton click");
            }
        });

        button.longClick(new IButtonLongClickEventHandler() {
            @Override
            public void longClick() {
                System.out.println("rectButton longClick");
            }
        });
    }

}

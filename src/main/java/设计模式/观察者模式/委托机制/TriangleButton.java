package 设计模式.观察者模式.委托机制;

public class TriangleButton extends IButton {
    @Override
    public void click(IButtonClickEventHandler handler) {
        handler.click();
    }

    @Override
    public void longClick(IButtonLongClickEventHandler handler) {
        handler.longClick();
    }
}

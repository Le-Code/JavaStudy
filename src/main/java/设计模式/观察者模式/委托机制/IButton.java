package 设计模式.观察者模式.委托机制;

public abstract class IButton {

    public abstract void click(IButtonClickEventHandler handler);

    public abstract void longClick(IButtonLongClickEventHandler handler);

}

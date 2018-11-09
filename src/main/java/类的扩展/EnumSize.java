package 类的扩展;

public enum  EnumSize {
    SMALL("s"),
    MEDIUM("m"),
    LARGE("l");

    private String label;

    EnumSize(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    public static EnumSize fromLabel(String label){
        for (EnumSize size:EnumSize.values()){
            if (size.getLabel().equals(label))
                return size;
        }
        return null;
    }
}

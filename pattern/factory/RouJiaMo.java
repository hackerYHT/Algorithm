package pattern.factory;

public abstract class RouJiaMo {
    protected String name;
    /*
    准备工作
     */
    public void prepare(){
        System.out.println("揉面-剁肉-完成准备工作");
    }
    /*
    开始烧肉夹馍
     */
    public void fire(){
        System.out.println("开始烧肉夹馍");
    }
    /*
    使用你们的专用袋-包装袋
     */
    public void pack(){
        System.out.println("肉夹馍-专用设备-烘烤");
    }
}

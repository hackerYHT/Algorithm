package pattern.factory;

public class RouJiaMoStore {
    /**
     * 根据传入类型卖不同的肉夹馍
     *
     * @param type
     * @return
     */
//    public RouJiaMo sellRouJiaMo(String type){
//        RouJiaMo roujiamo = null;
//        if(type.equals("Suan")){
//            roujiamo = new SuanRouJiaMo();
//        }else if(type.equals("Tian")){
//            roujiamo = new TianRouJiaMo();
//        }else if(type.equals("La")){
//            roujiamo = new LaRouJiaMo();
//        }
//        roujiamo.prepare();
//        roujiamo.fire();
//        roujiamo.pack();
//        return roujiamo;
//    }
    private SimpleRouJiaMoFactory factory;
    public RouJiaMoStore(SimpleRouJiaMoFactory factory){
        this.factory = factory;
    }
    public RouJiaMo sellRouJiaMo(String type){
        RouJiaMo roujiamo = factory.createRouJiaMo(type);
        roujiamo.prepare();
        roujiamo.fire();
        roujiamo.pack();
        return roujiamo;
    }
}

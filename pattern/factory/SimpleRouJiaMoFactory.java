package pattern.factory;

public class SimpleRouJiaMoFactory {
    public RouJiaMo createRouJiaMo(String type){
        RouJiaMo roujiamo = null;
        if(type.equals("Suan")){
            roujiamo = new SuanRouJiaMo();
        }else if(type.equals("Tian")){
            roujiamo = new TianRouJiaMo();
        }else if(type.equals("La")){
            roujiamo = new LaRouJiaMo();
        }
        return roujiamo;
    }
}

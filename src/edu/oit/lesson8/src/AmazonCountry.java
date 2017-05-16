/**
 * Created by IT on 2017/5/11.
 */
public enum AmazonCountry {
    US("US","https://www.amazon.com"),UK("UK","  https://www.amazon.co.uk"),DE("DE","https://www.amazon.de"),FR("FR","  https://www.amazon.fr"),JP("JP","co.jp");
    private String url;
    private String name;

    private AmazonCountry(String name, String url){
        this.url = url;
        this.name = name;

    }
    public void getName(){
        switch(this){
            case US:
                System.out.println(this.name);
                break;
            case UK:
                System.out.println(this.name);
                break;
            case DE:
                System.out.println(this.name);
                break;
            case FR:
                System.out.println(this.name);
                break;
            case JP:
                System.out.println(this.name);
                break;
            default:
                System.out.println("No in the range");
                break;
        }
    }

    public void getUrl(){
        switch (this){
            case US:
                System.out.println(this.url);
                break;
            case UK:
                System.out.println(this.url);
                break;
            case DE:
                System.out.println(this.url);
                break;
            case FR:
                System.out.println(this.url);
                break;
            case JP:
                System.out.println(this.url);
                break;
            default:
                System.out.println("No in the range");
                break;
        }
    }
}

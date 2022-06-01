public class Evidence {
    //배열을 클래스에 저장해서 그것을 메인클래스에서 불러오는 것이 안됨
    //배열이 클래스에 우선 저장이 되지않음, main 메소드가 없어서 그런것인가, 뭐가 잘못인지 모르겠다

    public String Description;
    public String E;

    Evidence(String Description, String E)
    {
        this.Description = Description;
        this.E = E;
    }


}

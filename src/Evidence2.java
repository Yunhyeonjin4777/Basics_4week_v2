//들어가기 전에 초기화의 예
public class Evidence2 {

    //명시적 초기화 ex)
    //String name = "현진";
    String name;
    String Description;
    int progress;

    //생성자 - 클래스와 같은 이름의 메서드
    //인스턴스 변수를 초기화하기 위해 사용한다(인스턴스 변수, static이 붙지 않은 변수)
    //클래스에 생성자는 반드시 하나 이상 존재해야 한다
    //생성자는 리턴타입이 없다
    //위에 선언한 인스턴스변수를 생성자의 파라미터를 사용해 초기화 한다
    Evidence2(String name, String Description, int progress)
    {
        this.name = name;//this사용으로 인스턴스 변수와 지역변수 구분할 수 있다
        this.Description = Description;
        this.progress = progress;
    }

    String evidenceInfo()
    {
        String info = Description + " : ";
        if(0<progress)
            info += "수사진행율 + " + progress;
        return info;
    }
}

/*public class ReferenceParameterDemo {


    public static void main(String[] args)
    {
        runReference2();
        runReferencee1();
        runValue();
    }

    static void _value(int b) //
    {
        b = 2; //a의 값이 변경되지 않음
    }
    static void runValue()
    {
        int a = 1; //기본데이터 타입
        _value(a); //a의 값 1이 복제돼서 b로 들어감
        System.out.println("runValue, " +a);
    }

    static void _reference1(A b) //매개변수 b에 a의 값을 넣는데
    //a가 값을 가지는 것이 아니라 인스턴스를 참조하기 때문데
    //b도 a가 가리키는 인스턴스를 참조한다
    {
        b = new A(2); //그러나 여기에 있는 변수는 인스턴스id의 값이 2
        //이기 때문에 위에 변수 b와 영향을 받지 않는다 다른 변수!
    }
    static void runReferencee1()
    {
        A a = new A(1); //변수 a에 인스턴스를 담음, 참조의 관계
        //id값은 1인 상태
        _reference1(a);
        System.out.println("runReference1, "a.id);
    }

    static void _reference2(A b)
    {
        b.id = 2;
    }
    static void runReference2()
    {
        A a = new A(1);
        _reference2(a);
        System.out.println("runReference2, " +a.id);

    }
}


class A
{
    public int id;
    A(int id)
    {
        this.id = id;
    }
}

*/
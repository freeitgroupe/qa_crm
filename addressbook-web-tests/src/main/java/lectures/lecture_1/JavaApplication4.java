package lectures.lecture_1;

public class JavaApplication4 {
    public static void main(String[] args) {
        int a = 5;
        a++;
        System.out.println("a = " + a);
        //float c = .5; ��� ���������� ������ ��� ��� ���������� ������ ��������
        float b = (float).5;//.5f
        b = 1.f / 0; // infinity
        System.out.println("b = " + b); // infinity
        if(a < b) System.out.println("OK"); // OK
    }

}


/*
    Garbage collector (������������ ������) -
        �� �� ����� ����� ����� gc ������� ������.
        ��������� gc ������ �������� ������ ����� ����������� �-�  System.out.println("a = " + a);

    ��� ��� ��� ����������� ?
        ����������� ��� ���� ��� ����������� �������, ��� ���� ���� ��� ������� � ������ ������� ��������� jvm
 */

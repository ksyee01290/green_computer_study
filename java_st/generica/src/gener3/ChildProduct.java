package gener3;

// 부모객체를 상속할때는 부모객체의 메개변수까지 넣어주어야 상속이가능하다.
public class ChildProduct<T, M, C> extends Product<T, M> {
    private C company;
    public C getCompany() { return this.company;}
    public void setCompany(C company) { this.company = company;}

}

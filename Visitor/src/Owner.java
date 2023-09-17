/**
 * 具体访问角色类
 */
public class Owner implements Person{
    @Override
    public void feed(Cat car) {
        System.out.println("主人喂食猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("主人喂食狗");
    }
}

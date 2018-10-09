/**
 *
 */
package yanheng.com;

/**
 * @author dang7
 *
 */
public class Hashcodetest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		test1();
		test2();
	}

	private static void test1() {
		// TODO 自動生成されたメソッド・スタブ
		String test1 = new String("555");
		String test2 = new String("555");

		System.out.println("------------hashcode------------");
		System.out.println(test1.hashCode());
		System.out.println(test2.hashCode());
		System.out.println("------------メモリアドレス------------");
		System.out.println(System.identityHashCode(test1));
		System.out.println(System.identityHashCode(test2));
		System.out.println("----------比較equals--------------");
		System.out.println(test1.equals(test2));
		System.out.println("----------比較　==　--------------");
		System.out.println(test1 == test2);

	}

	private static void test2() {
		// TODO 自動生成されたメソッド・スタブ
        Person p1 = new Person("田中", 32);
        Person p2 = new Person("田中", 32);
        Person p3 = new Person("田中", 33);
        System.out.printf("p1.equals(p2) : %s\n", p1.equals(p2));
        System.out.printf("p1==p2 : %s\n", p1==p2);

        System.out.printf("p1.equals(p3) : %s\n", p1.equals(p3));
	}

    private static class Person {
        int age;
        String name;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return name + " - " +age;
        }

        /**
         * @desc
         */
        @Override
        public boolean equals(Object obj){
            if(obj == null){
                return false;
            }

            if(this == obj){
                return true;
            }

            if(this.getClass() != obj.getClass()){
                return false;
            }

            Person person = (Person)obj;
            return name.equals(person.name) && age==person.age;
        }

        @Override
        public int hashCode() {
        	Person person = this;
        	return person.hashCode();
        }
    }

}

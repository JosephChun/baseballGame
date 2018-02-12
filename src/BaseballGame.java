import java.util.Scanner;

public class BaseballGame {
	
	public static int[] comNumber;
	public static int[] userNumber;
	
	public static int[] ranNumList() {
		int tmp,random;
		comNumber = new int[] {1,2,3,4,5,6,7,8,9};
		for(int i=0; i<comNumber.length; i++) {
			random = (int)(Math.random()*comNumber.length);
			random = Math.min(random,comNumber.length-1); // �ε��� ���� �ʿ�
			// swap
			tmp = comNumber[i];
			comNumber[i] = comNumber[random];
			comNumber[random] = tmp;
		}
		return comNumber;
	}
	
	
	public static int[] userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("���ڸ� �Է��� �ּ��� ex)123 : ");
		int userNum = scan.nextInt();
		userNumber = new int[3];
		for(int i = 2; i >= 0; i--) {
			userNumber[i] = userNum%10;
			userNum = userNum/10;
		}
		return userNumber;
	}
	
	public static int countStrike() {
		int strike = 0;
		for(int i=0; i<3; i++) {
			if (comNumber[i]==userNumber[i]) strike++;
		}
		return strike;
	}
	
	public static int countBall() {
		int ball = 0;
		for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if (i!=j && comNumber[i] == userNumber[j]) ball++;
            }
        }
		return ball;
	}
	
	public static void display() {
		
		if (countStrike() > 0 || countBall() > 0) { 
            System.out.println(countStrike() + " ��Ʈ����ũ " + countBall() + " ��");
		}
		
		if (countStrike() == 0 && countBall() == 0) {
			System.out.println("����");
		}
	}
	
	public static void playGame() {
		ranNumList();
		while(true) {
			userInput();
			countStrike();
			if(countStrike()==3) {
				System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");
				break;
			}
			countBall();
			display();
			
		}
	}

	public static void main(String[] args) {
		playGame();
	
	}

}

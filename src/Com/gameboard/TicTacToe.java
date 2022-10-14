package Com.gameboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static List<Integer> playerposition = new ArrayList<>();
	static List<Integer> compuerposition = new ArrayList<>();

	public static void printbaordgame(char[][] boardgame) {
		for (char[] row : boardgame) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public static void positioningame(char[][] boardgame, int position, String user) {
		char turn = ' ';
		if (user.equals("player")) {
			turn = 'X';
			playerposition.add(position);
		} else if (user.equals("computer")) {
			turn = 'O';
			compuerposition.add(position);
		}
		switch (position) {
		case 1:
			boardgame[0][0] = turn;
			break;
		case 2:
			boardgame[0][2] = turn;
			break;
		case 3:
			boardgame[0][4] = turn;
			break;
		case 4:
			boardgame[2][0] = turn;
			break;
		case 5:
			boardgame[2][2] = turn;
			break;
		case 6:
			boardgame[2][4] = turn;
			break;
		case 7:
			boardgame[4][0] = turn;
			break;
		case 8:
			boardgame[4][2] = turn;
			break;
		case 9:
			boardgame[4][4] = turn;
			break;

		}
	}

	public static String checkthewinner() {
		List<Integer> row1 = Arrays.asList(1, 2, 3);
		List<Integer> row2 = Arrays.asList(4, 5, 6);
		List<Integer> row3 = Arrays.asList(7, 8, 9);
		List<Integer> col1 = Arrays.asList(1, 4, 7);
		List<Integer> col2 = Arrays.asList(2, 5, 8);
		List<Integer> col3 = Arrays.asList(3, 6, 9);
		List<Integer> dia1 = Arrays.asList(1, 5, 9);
		List<Integer> dia2 = Arrays.asList(3, 5, 7);

		List<List<Integer>> Winningoption = new ArrayList<>();
		Winningoption.add(dia1);
		Winningoption.add(dia2);
		Winningoption.add(row1);
		Winningoption.add(row2);
		Winningoption.add(row3);
		Winningoption.add(col1);
		Winningoption.add(col2);
		Winningoption.add(col3);
		for (List<Integer> winner : Winningoption) {
			if (playerposition.containsAll(winner)) {
				return "congrats ! you won";
			} else if (compuerposition.containsAll(winner)) {
				return "cpu won ! better luck next time";
			} else if (playerposition.size() + compuerposition.size() == 9) {
				return "match tie";
			}
		}

		return "";

	}

	public static void main(String[] args) {
		char[][] boardgame = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', ' ' }, { ' ', '|', ' ', '|', ' ' } };
		printbaordgame(boardgame);

		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("enter the number :player");
			int playerturn;
			try {
				playerturn = scan.nextInt();
			} catch (Exception e) {
				System.out.println("invalid input ! enter the correct number");
				continue;
			}
			while (playerposition.contains(playerturn) || compuerposition.contains(playerturn)) {
				System.out.println("position is already taken ! try next spot");
				playerturn = scan.nextInt();
			}
			positioningame(boardgame, playerturn, "player");
			String result = checkthewinner();
			if (result.length() > 0) {
				System.out.println(result);
			}

			Random ran = new Random();
			int cputurn = ran.nextInt(9) + 1;
			while (playerposition.contains(cputurn) || compuerposition.contains(playerturn)) {
				System.out.println("position is already taken ! try next spot");
				cputurn = ran.nextInt(9) + 1;
			}
			positioningame(boardgame, cputurn, "computer");
			printbaordgame(boardgame);
			String result1 = checkthewinner();
			if (result.length() > 0) {
				System.out.println(result);
			}

		}

	}

}

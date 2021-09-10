package musicPlayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {

		Album album = new Album("Album 1", "Arijit Singh");

		album.addSong("Kabira", 3.55);
		album.addSong("Gerua", 3.0);
		album.addSong("Naina", 4.20);

		albums.add(album);

		album = new Album("Album 2", "Neha Kakkar");

		album.addSong("Kar Gayi Chull", 3.50);
		album.addSong("Tukur Tukur", 3.10);
		album.addSong("Cheez Badi", 4.0);

		albums.add(album);

		LinkedList<Song> playlist1 = new LinkedList<>();
		albums.get(0).addToPlaylist("Kabira", playlist1);
		albums.get(0).addToPlaylist("Gerua", playlist1);
		albums.get(1).addToPlaylist("Kar Gayi Chull", playlist1);
		albums.get(1).addToPlaylist("Cheez Badi", playlist1);

		play(playlist1);
	}

	private static void play(LinkedList<Song> playlist) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playlist.listIterator();

		if (playlist.size() == 0) {
			System.out.println("This playlist have no songs.");
		} else {
			System.out.println("Now playing " + listIterator.next().toString());
			Menu();
		}

		while (!quit) {
			int action = sc.nextInt();
			sc.nextLine();

			switch (action) {
			case 0:
				System.out.println("Playlist Complete.");
				quit = true;
				break;
			case 1:
				if (!forward) {
					if (listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				if (listIterator.hasNext()) {
					System.out.println("Now Playing " + listIterator.next().toString());
				} else {
					System.out.println("No song available. (End of the list.)");
					forward = false;
				}
				break;
			case 2:
				if (forward) {
					if (listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
				if (listIterator.hasPrevious()) {
					System.out.println("Now playing " + listIterator.previous().toString());
				} else {
					System.out.println("We are at the first song.");
					forward = false;
				}
				break;
			case 3:
				if (forward) {
					if (listIterator.hasPrevious()) {
						System.out.println("Now playing " + listIterator.previous().toString());
						forward = false;
					} else {
						System.out.println("We are at the start of the list.");
					}
				} else {
					if (listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
						forward = true;
					} else {
						System.out.println("We are at the end of list.");
					}
				}
				break;
			case 4:
				printlist(playlist);
				break;
			case 5:
				Menu();
				break;
			case 6:
				if (playlist.size() > 0) {
					listIterator.remove();
					if (listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
					} else {
						if (listIterator.hasPrevious()) {
							System.out.println("Now playing " + listIterator.previous().toString());
						}
					}
				}
			}
		}
		sc.close();
	}

	private static void Menu() {
		System.out.println("Available Options - Press");
		System.out.println("0 - Quit");
		System.out.println("1 - Play Next Song");
		System.out.println("2 - Play Previous Song");
		System.out.println("3 - Replay the Current Song");
		System.out.println("4 - List of All Songs");
		System.out.println("5 - Print All Options");
		System.out.println("6 - Delete Current Song");
	}

	private static void printlist(LinkedList<Song> playlist) {
		Iterator<Song> iterator = playlist.iterator();
		System.out.println("*************************************************");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("*************************************************");
	}

}

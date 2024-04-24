import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.logging.*;
import java.util.function.*;
import java.time.*;
import java.time.format.*;
import java.text.*;

public class Main {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		String dateString = date.format(DateTimeFormatter.ofPattern("dd_MM_yyyy"));
		System.out.println(dateString);
	}
}
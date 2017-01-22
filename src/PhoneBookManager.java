
import java.util.HashSet;
import java.util.Iterator;
import java.io.*;

/*
 * this class is used to handle data import/export into input/output file
 * handle search, delete data event
 *
 * 
 * @author  YueYang Yu  (EARL MARCH PUBLIC SCHOOL)
 * @version 1.0
 * @since   2017-01-22
 *  
 */

class PhoneBookManager {
	private final File dataFile = new File("src/inputPhoneBook.dat");
	private final File outdataFile = new File("src/outputPhoneBook.dat");
	HashSet<PhoneInfo> infoStorage = new HashSet<PhoneInfo>();

	static PhoneBookManager inst = null;

	/* create phonebook manager object and return the object */
	public static PhoneBookManager createManagerInst() {
		if (inst == null)
			inst = new PhoneBookManager();
		return inst;
	}

	/* empty constructor */
	private PhoneBookManager() {

	}

	/* search entry base on name */

	public String searchData(String name) {
		PhoneInfo info = search(name);
		if (info == null)
			return null;
		else
			return info.toString();
	}

	/* search entry base on phone number */
	public String searchPhone(String phone) {
		PhoneInfo info = searchPhoneNumber(phone);
		if (info == null)
			return null;
		else
			return info.toString();
	}

	/* common method to search entry base on any condition */

	public HashSet<PhoneInfo> searchAny(String srcString, String srcType) {
		HashSet<PhoneInfo> infoSearch = new HashSet<PhoneInfo>();
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (srcType.equals("name")) {
				if (srcString.compareTo(curInfo.name) == 0)
					infoSearch.add(curInfo);
			} else if (srcType.equals("type")) {
				if (srcString.compareTo(curInfo.type) == 0)
					infoSearch.add(curInfo);
			} else if (srcType.equals("school")) {
				if (srcString.compareTo(curInfo.school) == 0)
					infoSearch.add(curInfo);
			}

		}
		return infoSearch;
	}

	/* common method to delete entry base on any required condition */
	public boolean deleteData(String name) {
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (name.compareTo(curInfo.name) == 0) {
				itr.remove();
				return true;
			}
		}
		return false;
	}

	/* common method to search entry base on name */
	private PhoneInfo search(String name) {
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (name.compareTo(curInfo.name) == 0)
				return curInfo;
		}
		return null;
	}

	/* common method to search entry base on phoneNumber */
	private PhoneInfo searchPhoneNumber(String phone) {
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (phone.compareTo(curInfo.phoneNumber) == 0)
				return curInfo;
		}
		return null;
	}

	/* method to store current data into export output data file */
	public void storeToFile() {
		/* use try to catch exception */
		try {
			FileOutputStream file = new FileOutputStream(outdataFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
			Iterator<PhoneInfo> itr = infoStorage.iterator();
			while (itr.hasNext())
				out.writeObject(itr.next());
			out.close();
			PhoneBook.infoTextArea.append("export data from infoStrige to output data file successfully \n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* method to read entry from input data file */
	public void readFromFile() {
		if (dataFile.exists() == false)
			return;
		/* use try to catch exception */
		try {
			FileInputStream file = new FileInputStream(dataFile);
			ObjectInputStream in = new ObjectInputStream(file);
			while (true) {
				PhoneInfo info = (PhoneInfo) in.readObject();
				if (info == null)
					break;
				infoStorage.add(info);
				PhoneBook.infoTextArea.append("read data from input data file into infoStroge successfully \n");
			}

			in.close();

		} catch (IOException e) {
			return;
		} catch (ClassNotFoundException e) {
			return;
		}
	}

	/* method to print the table in current memory */
	public void printInfoStorage() throws IOException {
		Iterator<PhoneInfo> itr = infoStorage.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

	}

	/* method to store current data into export output data file */
	public void printPhoneBookTable() throws IOException {
		PrintPhoneBook frame = new PrintPhoneBook(infoStorage);
		frame.setVisible(true);
	}
}

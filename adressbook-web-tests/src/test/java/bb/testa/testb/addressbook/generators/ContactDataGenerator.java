package bb.testa.testb.addressbook.generators;
import bb.testa.testb.addressbook.model.ContactData;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "ContactCount")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();

    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")){
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")){
            saveAsXml(contacts, new File((file)));
        } else if (format.equals("json")){
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("unrecognized format" + format);
        }

    }
    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)){
            writer.write(json);

        }
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)){
            writer.write(xml);
        }
    }
    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (ContactData contact : contacts) {
                writer.write(String.format("%s;%s;%s%s%s\n",
                        contact.getFirstname(), contact.getLastname(), contact.getAddress(), contact.getMobilePhone(), contact.getEmail()));
            }
        }
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0 ; i < count ; i++){
            contacts.add(new ContactData().withFirstname(String.format("first %s" , i))
                    .withLastname(String.format("lastName %s", i)).withAddress(String.format("Adres %s", i))
                    .withMobilePhone(String.format("99999%s", i)).withEmail(String.format("email%s@test.pl", i)).withGroup("test1"));
        }
        return contacts;
    }


}

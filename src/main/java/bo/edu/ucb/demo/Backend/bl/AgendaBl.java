package bo.edu.ucb.demo.Backend.bl;

import bo.edu.ucb.demo.Backend.dao.ContactRepository;
import bo.edu.ucb.demo.Backend.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendaBl {

    private final ContactRepository contactRepository;

    @Autowired
    public AgendaBl(ContactRepository cr) {
        this.contactRepository =  cr;
    }

    public Contact createContact(Contact contact) {
        Contact result = this.contactRepository.save(contact);
        return result;
    }

    public Contact updateContact(Contact contact) {
        Contact result = this.contactRepository.save(contact);
        return result;
    }

    public Contact findContactByPk(Integer contactId) {
        Optional<Contact> result = this.contactRepository.findById(contactId);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("No existe un contacto para la llave primaria: " + contactId);
        }
    }

    public void deleteContact(Contact contact) {
        this.contactRepository.delete(contact);
    }


}

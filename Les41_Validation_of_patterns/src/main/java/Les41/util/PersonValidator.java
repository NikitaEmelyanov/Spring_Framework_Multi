package Les41.util;

import Les41.dao.PersonDAO;
import Les41.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class PersonValidator implements Validator {
    //Чтобы класс стал Валидатором нужно имплементировать интерфейс Validator, который приходит
    // из org.springframework.validation.Validator и реализовать 2 метода. В классе supports()
    // нужно дать понять на объекте какого класса этот валидатор можно использовать
    private final PersonDAO personDAO;
    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    //Чтобы посмотреть есть ли такой человек в БД, к ней нужно обратиться, для этого нужно
    // внедрить PersonDAO и создать конструктор, чтобы можно было обратиться к PersonDAO и
    // запросить Email, такого метода нет, поэтому можно сделать метод show() в PersonDAO
    // перегруженным и указать для него другие параметры


    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        // Используем Down-casting, чтобы привести объект класса object  к объекту класса Person
        //Посмотреть есть ли человек с таким же email'ом
        if (personDAO.show(person.getEmail()).isPresent()){ //isPresent() аналог проверки на null
            errors.rejectValue("email","","This email is already taken");
            //На объекте ошибки вызывается метод rejectValue с аргументами (поле, код ошибки,
            // сообщение ошибки)
        }
    }
}

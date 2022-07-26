package vttp2022.ssfworkshop16.services;

import jakarta.json.JsonObject;

public interface repo{
    public void save(JsonObject body);

    public String BoardGame(String boardGame);
}


//Sample Reference from SSFworkshop14//
// public interface ContactsRepo {
//     public void save(final Contact ctc);

//     public Contact findById(final String contactId);
// }
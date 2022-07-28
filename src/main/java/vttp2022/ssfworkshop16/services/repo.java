package vttp2022.ssfworkshop16.services;

import jakarta.json.JsonObject;
import vttp2022.ssfworkshop16.model.Welcome4;

public interface repo{
    public int save(JsonObject body);

    public Welcome4 BoardGame(String boardGame);

    public int update(JsonObject body);
}


//Sample Reference from SSFworkshop14//
// public interface ContactsRepo {
//     public void save(final Contact ctc);

//     public Contact findById(final String contactId);
// }
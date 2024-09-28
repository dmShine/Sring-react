import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [people, setPeople] = useState([]);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  useEffect(() => {
    axios.get("http://localhost:8080/api/people").then((response) => {
      setPeople(response.data);
    });
  }, []);

  const addPerson = () => {
    const newPerson = { name, email };
    axios.post("http://localhost:8080/api/people", newPerson).then((response) => {
      setPeople([...people, response.data]);
      setName("");
      setEmail("");
    });
  };

  return (
    <div>
      <h1>People List</h1>
      <ul>
        {people.map((person) => (
          <li key={person.id}>
            {person.name} - {person.email}
          </li>
        ))}
      </ul>

      <h2>Add Person</h2>
      <input
        type="text"
        placeholder="Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <button onClick={addPerson}>Add</button>
    </div>
  );
}

export default App;

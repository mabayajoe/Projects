import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Calendar from 'react-calendar';

const FindAppointments = () => {
  const [date, setDate] = useState(new Date());
  const [availableAppointments, setAvailableAppointments] = useState([]);

  useEffect(() => {
    // Mock API call to get available appointments
    axios.get(`/api/appointments?date=${date.toISOString()}`)
      .then(response => setAvailableAppointments(response.data))
      .catch(error => console.error("Error fetching appointments", error));
  }, [date]);

  return (
    <div>
      <h1>Select Appointment Date</h1>
      <Calendar onChange={setDate} value={date} />
      <h2>Available Appointments on {date.toDateString()}</h2>
      <ul>
        {availableAppointments.map(appt => (
          <li key={appt.id}>
            {appt.time} - {appt.doctor}
            <button>Book</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default FindAppointments;
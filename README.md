# Hotel Room Booking System

A simulated hotel room booking system for a group project for Software Testing course in UTAR. The functionalities of the code is tested using JUnit 4 and Mockito. 


The test case design documentation is provided in the ***Test_Case_Design.xlsx*** file.

## The system has the following requirements:

### 1. VIP member
- If VIP room is fully booked when a VIP member places a booking, Deluxe room will
be allocated instead.
- In case Deluxe room is fully booked, Standard room will be allocated.
- If Standard room is fully booked too, then the VIP member will be placed into VIP
waiting list.
- A VIP member can book up to 3 rooms at a time. If only one VIP room is available, the
other rooms can be both Deluxe or Standard rooms or combination of one Deluxe room
and one Standard room.
- If the number of rooms requested cannot be fulfilled, the member is placed into VIP
waiting list.


### 2. Normal member
- If Deluxe room is fully booked when a normal member places a booking,
  - Standard room will be allocated to member without exclusive reward.
  - A member with exclusive reward will be allocated VIP room subject to availability.
    - Upon allocation, the exclusive reward is marked redeemed.
    - If the VIP room is unavailable, Standard room will be allocated and the exclusive
reward remains valid for other redemptions.
- If Standard room is fully booked too, then the member will be placed into member
waiting list.
- A normal member can book up to 2 rooms at a time. The combinations of the rooms
allocated can be both Deluxe/Standard rooms, one VIP and one Deluxe, one VIP and
one Standard or one Deluxe and one Standard.
- If the number of rooms requested cannot be fulfilled, the member is placed into member
waiting list.


### 3. Non-member
- If Standard room is fully booked when a non-member places a booking, he/she will be
placed into normal waiting list.
- A non-member can book for only one room at a time.
- User is allowed to cancel the booking. If the user is in the waiting list, it must be removed
from the list.



## Dependencies:
- JUnit 4
- JUnitParams
- Mockito

## Instructions:
- Place the items in ***jar_files*** into your local C:/ drive.
- Add the JUnit 4 library into the project if required.

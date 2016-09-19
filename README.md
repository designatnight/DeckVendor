# DeckVendor

Goals:
Microservice that stores and shuffles card decks.
A Deck is an ordered list of 52 standard playing cards
Has a RESTfull interface
Can change out shuffling strategy at deploy time.

As a minimal viable product it needs to reach the major intended goals.

1. create new standard 52 card deck with a name
2. shuffle an already created deck
3. get a named deck

While get all and delete are intended features I did not see them as mission critical.
I made the the following assumptions to come to that conclusion.

1. This service would not be used for analytics style services where getting all decks
would be used more often than just getting a specific one.

2. Delete would not be critical, we are not storing any personal information, and our data 
size would not become an issue before we could implement it.

3. The ability to change shuffling strategy at deploy time is a primary feature, however
setting up a default shuffle would solve the overall goal.


Build instructions
to run:'mvn exec:java'


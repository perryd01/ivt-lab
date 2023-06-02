# GT4500

## Fire Torpedo

Tries to fire the torpedo stores of the ship.

### Parameters

#### firingMode
how many torpedo bays to fire
SINGLE: fires only one of the bays.
- For the first time the primary store is fired.
- To give some cooling time to the torpedo stores, torpedo
stores are fired alternating.
- But if the store next in line is empty, the ship tries to
fire the other store.
- If the fired store reports a failure, the ship does not
try to fire the other one.
ALL: tries to fire both of the torpedo stores.
### Return
   whether at least one torpedo was fired successfully

### Test cases

- Both stores are empty
  - SINGLE: failure
  - ALL: failure



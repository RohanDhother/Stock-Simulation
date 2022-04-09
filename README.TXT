Student name:Rohan Singh Dhother
Student number:190188632
Rohan Singh Dhother
Skype name - rohandhother_1

LEVEL YOU WISH THE MINI-PROJECT TO BE MARKED FOR: 3 [Level 3]

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called [Main]

This superclass is extended into at least three subclasses called [myShares, AllShares, Accounts]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [myShares] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [The shares name, value and amount of units]

These/this new properties/property are used by the subclass in the following way: [To record the shares properties and characteristics. lines 24,28 and 32.]

Subclass [myShares] extends the superclass by overriding the following methods (there must be at least one): [ in Shares.java getValue[line 78], getName[line 82], getUnits[line 86] and SetValue[line 90].]

These overridden methods are used in the working code in the following places: [in myShares.java getValue[line 12], getName[line 16], getUnits[line 20] and SetValue[line 32].]

Subclass 2.

Subclass [AllShares] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [The shares name, value and amount of units]

These/this new properties/property are used by the subclass in the following way: [To record the shares properties and characteristics. lines 26, 30 and 34.]

Subclass [Insert name of subclass] extends the superclass by overriding the following methods (there must be at least one): [in Shares.java getValue[line 78], getName[line 82], getUnits[line 86] and SetValue[line 90].]

These overridden methods are used in the working code in the following places: [in AllShares.java getValue[line 14], getName[line 18], getUnits[line 22] and SetValue[line 34]]

Subclass 3.

Subclass [Accounts] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [username and password]

These/this new properties/property are used by the subclass in the following way: [To record the accounts properties and characteristics lines 12, 35, 54 and 73.]

Subclass [Insert name of subclass] extends the superclass by overriding the following methods (there must be at least one): [in Main isUsername[21], isPassword[26], InitialiseUsers[31], UpdateUsers[35].]

These overridden methods are used in the working code in the following places: [in Accounts isUsername[54], isPassword[73], InitialiseUsers[12], UpdateUsers[35].]

[If you have more than three subclasses you want to tell us about, copy and paste the above text for as many subclasses as you want.]

LEVEL TWO!!!

[creating a instance of a subclass under the superclass(substitution principle) and having the same name(dynamic binding).]

[Creating instances of myShares and AllShares using Shares as the superclass. in Shares.java lines 55, 60 and 69.]

[Polymorphism is used in my code for creating myShares and AllShares under the superclass Shares, so i don't have to reuse code for editing the shares values and units. 
This is done for efficiency.
LEVEL THREE

[My code has one window for buying shares and has a input to indicate the amount of shares being bought and a buy button to buy them. 
This is similarly done on the portfolio page, however in that case the user us selling shares rather than buying them. 
The code will update the myShares and AllShares lists and their units for those shares and will update both the buyingShares window and the portfolio window to display the new information. 
Also used for starting the simulation and logining in. 
in Start.java line 19. in Login.java lines 44 and 53.
in BuyingShares.java line 85. in Portfolio line 70.
[for checking if a user enters a letter for the amount of shares to buy in BuyingShares.java line 129. in Portfolio line 120.
for using IO in Accounts lines 12 and 35. in Share lines 157, 181, 215 and 234.]

[Arraylists are used for the UsersList[in Main.java line 16, in Accounts.java lines 12, 35, 54 and 73], mySharesList[{in Portfolio.java line 34},{in Shares.java lines 11, 49, 94, 136, 152, 181, 234}] and SharesList[{in BuyingShares.java lines 51},{in Shares.java lines 12, 19, 49, 94, 115, 136, 152, 157,  215}].]

[When the simulation is stopped by pressing the stop button, the new values of AllShares and the units they now have are updated in the AllShares.txt file. 
If the user creates a new account then a new file for their shares is created using the username. 
When the simulation is stopped the shares the user now owns is updated and stored in the file [Username].txt.]

ANYTHING ELSE

[If there is anything else that you wish the marker to be aware of, please describe if (briefly) here.]
How to run program - in Main.java run void main(String[]) method to run the program.

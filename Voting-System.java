import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
public class VotingSystem {

static class Candidate {
String Name;
String Position;
int Votes;

Candidate(String Name, String Position) {

this.Name = Name;
this.Position = Position;
this.Votes = 0;

}
}

static ArrayList&lt;Candidate&gt; candidates = new ArrayList&lt;&gt;();
static Scanner input = new Scanner(System.in);
static HashMap&lt;String, String&gt; Account = new HashMap&lt;&gt;();
static HashMap&lt;String, Boolean&gt; HasVoted = new HashMap&lt;&gt;();

public static void main(String[] args) {

candidates.add(new Candidate(&quot;John Mark&quot;, &quot;President&quot;));

candidates.add(new Candidate(&quot;Lucy Grace&quot;, &quot;President&quot;));
candidates.add(new Candidate(&quot;Max George&quot;, &quot;President&quot;));

boolean running = true;

while(running) {
System.out.println(&quot;=== Main Menu ===&quot;);
System.out.println(&quot;1. Login/Signup&quot;);
System.out.println(&quot;2. Admin&quot;);
System.out.println(&quot;3. Exit&quot;);
System.out.print(&quot;Type &#39;1&#39; Login/Signup, &#39;2&#39; Admin, &#39;3&#39; Exit: &quot;);
String choice = input.nextLine();

if (choice.equals(&quot;1&quot;)) {

while(true) {
System.out.println(&quot;Login&quot;);
System.out.println(&quot;Signup&quot;);
System.out.print(&quot;Type either &#39;L&#39; or &#39;S&#39;: &quot;);
String Type = input.nextLine();

if (Type.equals(&quot;L&quot;)) {
Login();
break;
} else if (Type.equals(&quot;S&quot;)) {
Signup();
break;

} else { System.out.println(&quot;Wrong input! Type either &#39;L&#39; or &#39;S&quot;);}

}
} else if (choice.equals(&quot;2&quot;)) {
System.out.println(&quot;=== Admin ===&quot;);

while(true) {
System.out.print(&quot;Enter Username: &quot;);
String username = input.nextLine();
System.out.print(&quot;Enter Password: &quot;);
String password = input.nextLine();

if (!username.equals(&quot;admin&quot;) || !password.equals(&quot;123&quot;)) {
System.out.println(&quot;Your Username or Password is Incorrect/You Can&#39;t Leave both
Username and Password empty.&quot;
+ &quot;Try Again!&quot;);
} else if (username.equals(&quot;admin&quot;) &amp;&amp; password.equals(&quot;123&quot;)) {
System.out.println(&quot;Login Succefful!&quot;);
System.out.println(&quot;Proceeding into Admin Section&quot;);
admin();
break;
}
}
} else if (choice.equals(&quot;3&quot;)) {
System.out.print(&quot;Are Sure You Wanted to Exit Y/N: &quot;);
String confirm = input.nextLine();

if (confirm.equals(&quot;Y&quot;)) {

System.out.println(&quot;Goodbye&quot;);
running = false;
} else if (confirm.equals(&quot;N&quot;)) {
}
} else { System.out.println(&quot;Choose Only Between &#39;1-3&#39;&quot;); }
}
}
public static void Signup() {

System.out.println(&quot;=== Signup ===&quot;);

String user;
String pass;

while(true) {
System.out.print(&quot;Create Username: &quot;);
user = input.nextLine();

if (!user.equals(&quot;&quot;)){
break;
} System.out.println(&quot;Username Cannot be Empty. Try Again!&quot;);
}

while(true) {
System.out.print(&quot;Create Password: &quot;);
pass = input.nextLine();

if (!pass.equals(&quot;&quot;)){
break;
} System.out.println(&quot;Password Cannot be Empty. Try Again!&quot;);

}

Account.put(user, pass);
HasVoted.put(user, false);

System.out.println(&quot;Signup Successful!&quot;);
}
public static void Login() {

System.out.println(&quot;=== Login ===&quot;);

while(true) {
System.out.print(&quot;Enter Username: &quot;);
String user = input.nextLine();
System.out.print(&quot;Enter Password: &quot;);
String pass = input.nextLine();

if (!Account.containsKey(user) || !Account.get(user).equals(pass) ) {
System.out.println(&quot;Username or Password is incorrect&quot;);
System.out.print(&quot;Type &#39;B&#39; to Signup or &#39;C&#39; to Login: &quot;);
String type = input.nextLine();
if (type.equals(&quot;C&quot;)) {}
else if (type.equals(&quot;B&quot;)) { System.out.println(&quot;Proceeding to Signup&quot;);

Signup();
break;}
} else if (Account.containsKey(user) &amp;&amp; Account.get(user).equals(pass) ) {
System.out.println(&quot;Login successful!&quot;);
VotingSection(user);
break;
}
}
}
public static void VotingSection (String user) {

if (Boolean.TRUE.equals(HasVoted.get(user))) {
System.out.println(&quot;=== View Candidate ===&quot;);

for (int i = 0; i &lt; candidates.size(); i++) {
Candidate C = candidates.get(i);
System.out.println((i + 1) + &quot;. &quot; + C.Name + &quot; - &quot; + C.Position);
}

System.out.println(&quot;============&quot;);
System.out.println(&quot;You Alread Voted. You cannot Vote Again!&quot;);
System.out.print(&quot;Type &#39;B&#39; to return: &quot;);
String press = input.nextLine();
if (press.equals(&quot;B&quot;)) {
return;
}
}

showCandidates();

while(true) {
System.out.print(&quot;Choose Candidate Number:&quot;);
int Choice = input.nextInt();
input.nextLine();

if (Choice &gt;= 1 &amp;&amp; Choice &lt;= candidates.size()) {
candidates.get(Choice - 1).Votes++;
HasVoted.put(user, true);
System.out.println(&quot;Vote Counted&quot;);
break;
} else { System.out.println(&quot;Invalid Choice!&quot;);
}
}
System.out.print(&quot;Do you wanted to &#39;Y&#39; return to Main menu or &#39;N&#39; Back to
VotingSection: &quot;);
String choose = input.nextLine();

if (choose.equals(&quot;Y&quot;)) {
return;
} else if (choose.equals(&quot;N&quot;)) {
VotingSection(user);
}
}

public static void showCandidates () {

System.out.println(&quot;=== Candidate List ===&quot;);

for (int i = 0; i &lt; candidates.size(); i++) {
Candidate C = candidates.get(i);
System.out.println((i + 1) + &quot;. &quot; + C.Name + &quot; - &quot; + C.Position);
}
}

public static void admin () {
while(true) {
System.out.println(&quot;=== Admin Section ===&quot;);
System.out.println(&quot;1.Add Candidates&quot;);
System.out.println(&quot;2.Show Ranking&quot;);
System.out.println(&quot;3.Back to Main Menu&quot;);

System.out.print(&quot;Choose &#39;1&#39;, &#39;2&#39;, &#39;3&#39;: &quot;);
String num = input.nextLine();

if (num.equals(&quot;1&quot;)) {
AddCandidates();
} else if (num.equals(&quot;2&quot;)) {
ShowRanking();
} else if (num.equals(&quot;3&quot;)) {
return;
} else {
System.out.println(&quot;Wrong input. Try Again!&quot;);
}

}
}
public static void AddCandidates() {
System.out.println(&quot;=== ADD CANDIDATES ===&quot;);

while(true) {

System.out.print(&quot;Enter the Candidate Name: &quot;);
String man = input.nextLine();
System.out.print(&quot;Enter the Candidate Position: &quot;);
String pose = input.nextLine();

candidates.add(new Candidate(man, pose));

System.out.print(&quot;Do you Want to ADD more? Y/N: &quot;);
String Decision = input.nextLine();

if (Decision.equals(&quot;Y&quot;)) {}
else if (Decision.equals(&quot;N&quot;)) {
return;
}
}
}
public static void ShowRanking() {

ArrayList&lt;Candidate&gt; sorted = new ArrayList&lt;&gt;(candidates);

// Sort Highest Votes First
sorted.sort((a, b) -&gt; b.Votes - a.Votes);

System.out.println(&quot;=== Candidate Ranking ===&quot;);

for(int i = 0; i &lt; sorted.size(); i++) {

Candidate c = sorted.get(i);
System.out.println((i + 1) + &quot;. &quot; + c.Name + &quot; - &quot; + c.Position + &quot; | Votes: &quot; +
c.Votes);
}

System.out.println(&quot;===================&quot;);
System.out.print(&quot;Back to Admin Section &#39;Y&#39;: &quot;);
String the = input.nextLine();

if (the.equals(&quot;Y&quot;)) {}

}
}
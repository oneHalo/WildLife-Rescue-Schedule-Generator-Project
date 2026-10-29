# WILDLIFE_SCHEDULE

## Database login

The database login is no longer written in the code. `Schedule.java` reads it from three environment variables when it connects:

| Variable | What it holds |
| --- | --- |
| `DB_URL` | The JDBC address of the database, for example `jdbc:mysql://127.0.0.1:3306/EWR` |
| `DB_USER` | The database user name |
| `DB_PASSWORD` | The password for that user |

Set them before you run the program.

Linux or macOS:

```
export DB_URL="jdbc:mysql://127.0.0.1:3306/EWR"
export DB_USER="your_user"
export DB_PASSWORD="your_password"
```

Windows (PowerShell):

```
$env:DB_URL = "jdbc:mysql://127.0.0.1:3306/EWR"
$env:DB_USER = "your_user"
$env:DB_PASSWORD = "your_password"
```

If a variable is missing, the program prints which one and does not connect.

Why: a password in the code is copied into every clone and every commit. Keeping it in the environment means each person or server uses its own login, and the password never goes into git.

Note: the old password is still in the git history. Change it on the database, because anyone with access to the repo can read the old one.

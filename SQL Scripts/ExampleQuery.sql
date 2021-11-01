USE testerdb;
SELECT tester.ID as testerID, FirstName, LastName, Country, LastLogin, devices.ID as DeviceID, devices.Descr, COUNT(bugs.ID) as bugCount
FROM tester
INNER JOIN tester_devices
 ON tester_devices.TesterID = tester.ID
 INNER JOIN devices
 ON devices.ID = tester_devices.DeviceID
 INNER JOIN bugs
 ON tester.ID = bugs.TesterID
 WHERE bugs.DeviceID = devices.ID AND tester.ID AND tester.country = "US" AND (devices.Descr = "iPhone 4" OR devices.Descr = "iPhone 5")
 GROUP BY DeviceID, testerID;

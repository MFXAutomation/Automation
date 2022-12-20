'Updated Date: 3/12/2019
'Modified By: Dimpal B R

'User Profile Path
Set oShell = CreateObject("WScript.Shell")
'strHomeFolder = oShell.ExpandEnvironmentStrings("%USERPROFILE%")
Set xmlFSO = CreateObject("Scripting.FileSystemObject")
strHomeFolder = xmlFSO.GetParentFolderName(WScript.ScriptFullName)

'Read testcase from excel and create a testng.xml
Set objExcel = CreateObject("Excel.Application")
Set objWB = objExcel.Workbooks.Open(strHomeFolder & "\Regression_Suite.xlsx")
objExcel.Visible = False
Set tc_WS = objWB.Worksheets("Testcase")
Set temp_WS = objWB.Worksheets("Module")
Set regSuite_WS = objWB.Worksheets("RegressionSuite")
tcColumn = tc_WS.UsedRange.Columns.Count
tcRow = tc_WS.UsedRange.Rows.Count
tempRow = temp_WS.UsedRange.Rows.Count
regRow = regSuite_WS.UsedRange.Rows.Count
regCol = regSuite_WS.UsedRange.Columns.Count


If (xmlFSO.FileExists(strHomeFolder&"\testng.xml")) Then
xmlFSO.DeleteFile strHomeFolder & "\testng.xml"
Set openFile = xmlFSO.CreateTextFile(strHomeFolder&"\testng.xml")
		openFile.WriteLine "<?xml version=" & chr(34) & "1.0" & chr(34) & " encoding=" &chr(34)&"UTF-8" & chr(34) &"?>"
		openFile.WriteLine "<!DOCTYPE suite SYSTEM " & chr(34) & "http://testng.org/testng-1.0.dtd" & chr(34) & ">"
		openFile.WriteLine "<suite name=" & chr(34) & "Suite" & chr(34) & " parallel=" & chr(34) & "tests" & chr(34) & " thread-count=" & chr(34) & "1" & chr(34) &">"
			regScenarioNames=""
			environmentStatus=""
			For reg_i = 2 to regRow
				For reg_j = 3 to 5
					executionStatus = regSuite_WS.Cells(reg_i,reg_j)
					If 	executionStatus = "Yes" Or executionStatus = "yes" Then
						environmentStatus = regSuite_WS.Cells(1,reg_j)
						scenarioName1 = regSuite_WS.Cells(reg_i,1) & "_" & environmentStatus
						
						scenarioName = regSuite_WS.Cells(reg_i,1)
						regScenarioNames = regScenarioNames & scenarioName1 & ";"
						'regScenarioNames = regScenarioNames & scenarioName & ";"
						For tc_i = 1 to tcColumn 
							If tc_WS.Cells(1,tc_i) = scenarioName Then
								openFile.WriteLine "<test name=" & chr(34) & scenarioName1 & chr(34) & " preserve-order=" & chr(34) & "true" & chr(34) &">"
								openFile.WriteLine "<classes>"
								tempClassName = ""
								For tc_j = 2 to tcRow
									methodName = tc_WS.Cells(tc_j,tc_i)
									flag = true
									For temp_i = 2 To tempRow Step 1
										If temp_WS.Cells(temp_i,1) = methodName AND methodName <> "" Then
											className = temp_WS.Cells(temp_i,2)
											packageName = temp_WS.Cells(temp_i,3)
											If flag = true AND className <> tempClassName AND tempClassName <> "" Then
												openFile.WriteLine "</methods>"
												openFile.WriteLine "</class>"
												flag = false
											End If
											If className = tempClassName Then
												flag = true
												openFile.WriteLine "<include name=" & chr(34) & methodName & chr(34) & "/>"
												tempClassName = className
											Else
												flag = true
												openFile.WriteLine "<class name=" & chr(34) &packageName & "." & className & chr(34) & ">"
												openFile.WriteLine "<methods>"
												openFile.WriteLine "<include name=" & chr(34) & methodName & chr(34) & "/>"
												tempClassName = className
											End If
										End If
									Next
								Next
								openFile.WriteLine "</methods>"
								openFile.WriteLine "</class>"
								openFile.WriteLine "</classes>"
								openFile.WriteLine "</test>"
							End If
						Next
					End If
				Next
			Next
			openFile.WriteLine "</suite>"
	Set xmlFSO = Nothing
End If 

Set tc_Scenario = objWB.Worksheets("Email")
'tc_Scenario.Cells(1,15) = regScenarioNames
tc_Scenario.Cells(1,15) = regScenarioNames

objWB.Save
objWB.Close
Set objWB = Nothing
Set objExcel = Nothing
Set oShell = Nothing





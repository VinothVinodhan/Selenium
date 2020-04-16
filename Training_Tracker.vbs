Dim Excel, Sheet
Set Excel= CreateObject("Excel.Application") 'Open Mapping Sheet
Set objWorkbook = Excel.Workbooks.Open("C:\Users\manju\Desktop\Selenium\Selenium\List.xlsx")
'Excel.visible = False
Set Sheet = Excel.ActiveSheet
Dim Bug, Excelone, Exceltwo, Excelthree, Sheetone, Sheettwo, Sheetthree, objWorkbook, Sheetd
Set objFSO=CreateObject("Scripting.FileSystemObject")
' How to write file
outFile="C:\Users\manju\Desktop\Selenium\Selenium\Today.txt"
Set objFile = objFSO.CreateTextFile(outFile,True)
objFile.Write "Hi," & vbCrLf
objFile.Write " " & vbCrLf
objFile.Write "Following are the courses found in my learning" & vbCrLf & vbCrLf
Dim arr(10)
rowcount=2
rowno=5
while sheet.cells(rowcount,1) <> ""
getDetail=sheet.cells(rowcount,2)
objFile.Write getDetail & vbCrLf
rowno=rowno+1
rowcount=rowcount+1
wend
rowno=rowno+1
rowno=rowno+1
rowno=rowno+1
objFile.Write " " & vbCrLf
objFile.Write " " & vbCrLf
objFile.Close

Dim mainWB
Dim SendID
Dim CCID
Dim Subject
Dim Body
Dim olMail 
Set otlApp = CreateObject("Outlook.Application")
Set olMail = otlApp.CreateItem(olMailItem)
Set Doc = olMail.GetInspector.WordEditor
'Dim colAttach As Outlook.Attachments
Dim oAttach 
SendID = "v.periasamy@accenture.com"
CCID = "v.periasamy@accenture.com"
Subject = "List of My Learning Trainings"
With olMail
    .To = SendID
    If CCID <> "" Then
      .CC = CCID
    End If
    .Subject = Subject
        .Body=""


	 
Set objFSO=CreateObject("Scripting.FileSystemObject")
strFile = "C:\Users\manju\Desktop\Selenium\Selenium\Today.txt"
Set objFile = objFSO.OpenTextFile(strFile)
Do Until objFile.AtEndOfStream
    strLine= objFile.ReadLine
'msgbox(strLine)


.HTMLBody = .HTMLBody & strLine & "<br>"

Loop
objFile.Close

    .HTMLBody = .HTMLBody & "" _
                & "<br>Thanks and Regards, <br>Vinoth</font></span>"
'    .Display
  .Send
End With
Set otlApp = Nothing

Excel.Quit
Set Excel = Nothing




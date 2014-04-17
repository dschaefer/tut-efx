set fso	= CreateObject("Scripting.FileSystemObject")
rootDirName	= fso.GetParentFolderName(Wscript.ScriptFullName)
set pluginDir = fso.GetFolder(rootDirName +	"\plugins")

for each file in pluginDir.Files
  if (not StrComp("org.eclipse.equinox.launcher_", Left(file.Name, 29))) Then
     launcher =	file.Name
  end if
next

set shell = CreateObject("WScript.Shell")
command	= "javaw -Dorg.osgi.framework.bundle.parent=ext -jar """ + rootDirName + "\plugins\" + launcher	+ """"
shell.run(command)

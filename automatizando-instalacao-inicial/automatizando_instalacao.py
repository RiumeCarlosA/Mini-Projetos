import pyautogui
import os
import time
def esperar(nomeDiretorio):
    while(os.path.exists(nomeDiretorio) == False):
        time.sleep(1)
pyautogui.confirm(text='O computador será controlado, por favor não mexa até ser concluído', title='Alerta', buttons=['OK', 'Cancel'])
os.startfile("C:\WINDOWS\system32\cmd.exe")
pyautogui.alert(text= "cheguei ate aqui")
pyautogui.write('mkdir C:\Formatacao')
pyautogui.press('enter') 
pyautogui.write('xcopy D:\Formatacao C:\Formatacao /y /s /c /D')
pyautogui.press('enter')
esperarCopia = r"C:\Formatacao\Office2016\office\data\16.0.4266.1003"
while(os.path.exists(esperarCopia) == False):
    time.sleep(1)
os.startfile("C:\Formatacao\ChromeSetup.exe")
esperarChrome = r"C:\Program Files\Google\Chrome\Application\97.0.4692.71\Installer\setup.exe"
while(os.path.exists(esperarChrome) == False):
    time.sleep(1)
os.startfile("C:\Formatacao\readerdc64_br_xa_crd_install.exe")
pyautogui.press('left')
pyautogui.press('enter')
esperarReader = r"C:\Program Files (x86)\Adobe\Acrobat Reader DC\Reader\ngl_resources\resources\ui\font\regular"
while(os.path.exists(esperarReader) == False):
    time.sleep(1)
os.startfile("C:\Formatacao\Winrar-5.50-Final\Winrar 5.50 Final\Winrar 5.50 64 Bits.exe")
pyautogui.press('enter')
esperarWinrar = r"C:\Program Files\WinRAR\winRAR.exe"
while(os.path.exists(esperarWinrar) == False):
    time.sleep(1)
pyautogui.press('enter')
time.sleep(1)
pyautogui.press('enter')
time.sleep(1)
os.startfile("C:\Formatacao\Office2016\setup.exe")

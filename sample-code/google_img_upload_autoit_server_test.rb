require 'selenium-webdriver'
image_path="C:\\Users\\xyz\\Desktop\\images.jpg"
driver=Selenium::WebDriver.for :chrome
driver.get 'https://images.google.com/imghp?hl=en&gws_rd=ssl'
driver.manage.window.maximize

driver.find_element(:xpath ,".//*[@id='qbi']").click
driver.find_element(:xpath ,".//a[contains(text(),'Upload an image')]").click
driver.find_element(:xpath ,".//*[@type='file']").click

url0=URI.encode('http://localhost:8080/autoit/explicitWait?timeOut=5000')
url = URI.parse(url0)
req = Net::HTTP::Get.new(url.to_s)
res = Net::HTTP.start(url.host, url.port) {|http| http.request(req)}

sleep 3

url0=URI.encode('http://localhost:8080/autoit/sendKeys?title=Open&text=&controlID=Edit1&value=#{image_path}')
url = URI.parse(url0)
req = Net::HTTP::Get.new(url.to_s)
res = Net::HTTP.start(url.host, url.port) {|http| http.request(req)}

sleep 3

url0=URI.encode('http://localhost:8080/autoit/click?title=Open&text=&controlID=Button1')
url = URI.parse(url0)
req = Net::HTTP::Get.new(url.to_s)
res = Net::HTTP.start(url.host, url.port) {|http| http.request(req)}


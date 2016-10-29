__author__ = 'Kyle Brueggeman'

import requests
import json

# Need to install the requests library if you do not have it
# Instructions here: http://docs.python-requests.org/en/latest/user/install/#install

invoicesUrl = 'http://54.172.195.201:8081/invoices/'
invoice1 = {
    "invoiceNo": "10049",
    "companyName": "Comfort Air",
    "typeOfWork": "Mechanical",
    "status": "Sent",
    "price": "41.23",
    "comment": "Fixed a light bulb.",
    "dueDate": "2016-05-01"
}
invoice2 = {
    "invoiceNo": "10050",
    "companyName": "John Smith Plumbing",
    "typeOfWork": "Plumbing",
    "status": "Paid",
    "price": "75.00",
    "comment": "Installed new toilet",
    "dueDate": "2016-08-09"
}
invoice3 = {
    "invoiceNo": "10051",
    "companyName": "General Construction",
    "typeOfWork": "Construction",
    "status": "Draft",
    "price": "215.00",
    "comment": "Installed new door frame.",
    "dueDate": "2016-04-11"
}
invoice4 = {
    "invoiceNo": "10052",
    "companyName": "John Smith Plumbing",
    "typeOfWork": "Plumbing",
    "status": "Past Due",
    "price": "25.00",
    "comment": "Fixed leaky faucet.",
    "dueDate": "2016-01-02"
}


def getInvoices():
    print("Getting all invoices")
    req = requests.get(invoicesUrl)
    response = req.json()
    return response


def getInvoice(invoiceNo):
    req = requests.get(invoicesUrl + invoiceNo)
    if req.status_code == 404:
        print('Invoice ' + invoiceNo + ' was not found')
        return
    response = req.json()
    return response


def deleteInvoice(invoiceNo):
    req = requests.delete(invoicesUrl + invoiceNo)
    if req.status_code == 400:
        print('Deleting invoice ' + invoiceNo + ' had a problem')
        return


def deleteAllInvoices():
    invoicesToDelete = getInvoices()
    for x in invoicesToDelete:
        print('Deleting invoiceNo: ' + x['invoiceNo'])
        deleteInvoice(x['invoiceNo'])


def createTestData():
    json_data = json.dumps(invoice1)
    createInvoice(json_data)

    json_data = json.dumps(invoice2)
    createInvoice(json_data)

    json_data = json.dumps(invoice3)
    createInvoice(json_data)

    json_data = json.dumps(invoice4)
    createInvoice(json_data)


def createInvoice(invoice):
    headers = {'Content-type': 'application/json'}
    req = requests.post(invoicesUrl, data=invoice, headers=headers)
    if req.status_code != 200:
        print('Problem creating invoice')
        print(req.content)
    else:
        print('Successfully created invoice')


deleteAllInvoices()
createTestData()

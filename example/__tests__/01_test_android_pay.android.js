import helper from 'tipsi-appium-helper'
import test from './utils/tape'
import openTestSuite from './common/openTestSuite'

const { driver, idFromAccessId } = helper
const timeout = 60000

test('Test if user can use Android Pay', async (t) => {
  const header = idFromAccessId('headerText')
  const androidPayButton = idFromAccessId('androidPayButton')

  await openTestSuite('Android Pay')

  let e = await (await driver.$(header)).waitForDisplayed(timeout)
  t.pass('User should see `Android Pay Example` text')

  e = await (await driver.$(androidPayButton)).waitForDisplayed(timeout)
  t.pass('User should see `Pay with Android Pay` button')

  // to be continued ...
})

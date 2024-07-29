import Foundation

@objc public class IrTransmitter: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}

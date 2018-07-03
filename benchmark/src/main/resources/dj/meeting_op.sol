pragma solidity ^0.4.19;

import "./register.sol";
import "./type/meeting_event.sol";


/// @title The operation of meeting
/// @author ["Cryptape Technologies <contact@cryptape.com>"]
/// @dev TODO Should decide the params of modifyMeeting
contract MeetingOp is MeetingEvent {
    Register register;

    modifier onlyCommittee {
        require(register.isCommittee(msg.sender));
        _;
    }

    /// Save register's address
    function MeetingOp() public {
        register = Register(msg.sender);
    }

    /// @notice Add log about upload meeting
    /// @param _launchOrg Who launch the meeting
    /// @param _meetType Type of the meeting
    /// @param _meetId Id of the meeting
    /// @param _basicInfo include:
    ///          _meetDigest
    ///          _meetName
    ///          _lecturer
    ///          _topic
    ///          _meetDate
    ///          _startTime
    ///          _endTime
    ///          _location
    ///          _fileHash
    function uploadMeeting(
        bytes32 _meetId,
        bytes32 _launchOrg,
        bytes32 _launchPerson,
        bytes32 _meetType,
        bytes32[] _basicInfo,
        uint _planedPersons,
        uint _actualPersons,
        bytes32 _operateDate,
        bytes32 _operateTime,
        bytes32 _operator,
        bytes32 _desc
    )
        public
        onlyCommittee
    {
        MeetingUploaded(
            msg.sender,
            _meetId,
            _launchOrg,
            _launchPerson,
            _meetType,
            _basicInfo,
            _planedPersons,
            _actualPersons,
            _operateDate,
            _operateTime,
            _operator,
            _desc
        );
    }
}
